package playwithus.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import playwithus.server.model.Game;
import playwithus.server.model.User;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<Iterable<User>> findAllByGames(Game game);
}
