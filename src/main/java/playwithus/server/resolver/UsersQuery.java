package playwithus.server.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import playwithus.server.model.Game;
import playwithus.server.model.User;
import playwithus.server.repository.GamesRepository;
import playwithus.server.repository.UsersRepository;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Component
@AllArgsConstructor
public class UsersQuery implements GraphQLQueryResolver {

  private final UsersRepository usersRepository;

  private final GamesRepository gamesRepository;

  public Iterable<User> findAllUsers(){
    return usersRepository.findAll();
  }

  public Iterable<Game> findAllGamesByUserId(Long userId){
    Optional<User> userOptional = usersRepository.findById(userId);
    return userOptional.map(gamesRepository::findGamesByUser).orElse(null);
  }
}
