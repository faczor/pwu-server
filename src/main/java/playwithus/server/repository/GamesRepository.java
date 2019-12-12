package playwithus.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import playwithus.server.model.Game;

@Repository
public interface GamesRepository extends CrudRepository<Game, Long> {}
