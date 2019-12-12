package playwithus.server.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import playwithus.server.model.Address;
import playwithus.server.model.Playground;
import playwithus.server.repository.AddressesRepository;

@Component
@AllArgsConstructor
public class PlaygroundsResolver implements GraphQLResolver<Playground> {

    private final AddressesRepository addressesRepository;

    public Address addresses(Playground playground){
        return addressesRepository.findByPlayground(playground).orElse(null);
    }
}
