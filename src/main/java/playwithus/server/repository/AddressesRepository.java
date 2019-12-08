package playwithus.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import playwithus.server.model.Addresses;

@Repository
public interface AddressesRepository extends CrudRepository<Addresses, Long> {}
