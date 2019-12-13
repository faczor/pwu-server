package playwithus.server.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import playwithus.server.model.Game;
import playwithus.server.repository.GamesRepository;

@Component
@AllArgsConstructor
public class GamesQuery implements GraphQLQueryResolver {

    private final GamesRepository gamesRepository;

    public Iterable<Game> findAllGames(){
        return gamesRepository.findAll();
    }

    public Game findGameById(Long gameId){
        return gamesRepository.findById(gameId).orElse(null);
    }
}
