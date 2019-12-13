package playwithus.server.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import playwithus.server.model.Address;
import playwithus.server.repository.AddressesRepository;
import playwithus.server.response.ServerResponse;

@Component
@AllArgsConstructor
public class AddressMutation implements GraphQLMutationResolver {

    private final AddressesRepository addressesRepository;

    public ServerResponse addAddress(String country, String city, String zipCode, double latitude, double longitude){
        //Todo add Validation
        addressesRepository.save(new Address(country, city, zipCode, latitude, longitude));
        return new ServerResponse();
    }
}
