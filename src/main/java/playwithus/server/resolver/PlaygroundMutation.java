package playwithus.server.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import playwithus.server.model.Address;
import playwithus.server.model.Playground;
import playwithus.server.repository.AddressesRepository;
import playwithus.server.repository.PlaygroundsRepository;
import playwithus.server.response.Response;
import playwithus.server.response.ServerResponse;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PlaygroundMutation implements GraphQLMutationResolver {

    private final PlaygroundsRepository playgroundsRepository;

    private final AddressesRepository addressesRepository;

    public ServerResponse addPlayground(String name, boolean inDoor, Long addressId){
        if(playgroundsRepository.findByName(name).isEmpty()) {
            Optional<Address> address = addressesRepository.findById(addressId);
            if(address.isPresent()) {
                if(playgroundsRepository.findByAddress(address.get()).isEmpty()) {
                    Playground playground = new Playground(name, inDoor, address.get());
                    playgroundsRepository.save(playground);
                    return new ServerResponse();
                }
                return new ServerResponse(Response.PWUE1007);
            }
            return new ServerResponse(Response.PWUE1006);
        }
        return new ServerResponse(Response.PWUE1005);
    }
}
