package playwithus.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import playwithus.server.model.Playgrounds;

@Repository
public interface PlaygroundsRepository extends CrudRepository<Playgrounds, Long> {}
