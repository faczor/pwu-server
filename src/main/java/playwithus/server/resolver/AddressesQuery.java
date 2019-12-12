package playwithus.server.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import playwithus.server.model.Address;
import playwithus.server.repository.AddressesRepository;
import playwithus.server.response.ServerResponse;

@Component
@AllArgsConstructor
public class AddressesQuery implements GraphQLQueryResolver {

    private final AddressesRepository addressesRepository;

    public ServerResponse addAddress(String country, String zipcode, String street, double latitude, double longitude){
        //Todo add Validation
        addressesRepository.save(new Address(country, zipcode, street, latitude, longitude));
        return new ServerResponse();
    }
}
