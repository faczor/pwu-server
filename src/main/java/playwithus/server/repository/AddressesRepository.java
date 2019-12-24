package playwithus.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import playwithus.server.model.Address;
import playwithus.server.model.Playground;

import java.util.Optional;

@Repository
public interface AddressesRepository extends CrudRepository<Address, Long> {
    Optional<Address> findByPlayground(Playground playground);
}
