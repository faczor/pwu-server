package playwithus.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import playwithus.server.model.Address;
import playwithus.server.model.Game;
import playwithus.server.model.Playground;

import java.util.Optional;

@Repository
public interface PlaygroundsRepository extends CrudRepository<Playground, Long> {
    Optional<Playground> findByGame(Game game);
    Optional<Playground> findByName(String name);
    Optional<Playground> findByAddress(Address address);
}
