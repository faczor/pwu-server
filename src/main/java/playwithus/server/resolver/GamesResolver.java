package playwithus.server.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import playwithus.server.model.Game;
import playwithus.server.model.Playground;
import playwithus.server.model.User;
import playwithus.server.repository.PlaygroundsRepository;
import playwithus.server.repository.UsersRepository;

@Component
@AllArgsConstructor
public class GamesResolver implements GraphQLResolver<Game> {

    private final UsersRepository usersRepository;

    private final PlaygroundsRepository playgroundsRepository;

    public Playground playgrounds(Game game) {
        return playgroundsRepository.findByGame(game).orElse(null);
    }

    public Iterable<User> users(Game game) {
        return usersRepository.findAllByGames(game).orElse(null);
    }
}
