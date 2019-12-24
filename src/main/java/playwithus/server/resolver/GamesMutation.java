package playwithus.server.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import playwithus.server.model.Game;
import playwithus.server.model.Playground;
import playwithus.server.model.User;
import playwithus.server.repository.GamesRepository;
import playwithus.server.repository.PlaygroundsRepository;
import playwithus.server.repository.UsersRepository;
import playwithus.server.response.Response;
import playwithus.server.response.ServerResponse;

import java.sql.Timestamp;
import java.util.*;

@Component
@AllArgsConstructor
public class GamesMutation implements GraphQLMutationResolver {

    private final GamesRepository gamesRepository;

    private final PlaygroundsRepository playgroundsRepository;

    private final UsersRepository usersRepository;

    public ServerResponse addGame(String name, int price, int slots, Long start, int length, Long playgroundId, Long userId) {
        if (price < 0)
            return new ServerResponse(Response.PWUE1008);
        if (slots < 0)
            return new ServerResponse(Response.PWUE1009);
        if (length < 0)
            return new ServerResponse(Response.PWUE1010);
        Timestamp startDate = new Timestamp(start * 1000);
        if (startDate.after(new Timestamp(System.currentTimeMillis()))) {
            Optional<User> user = usersRepository.findById(userId);
            if (user.isPresent()) {
                Optional<Playground> playground = playgroundsRepository.findById(playgroundId);
                if (playground.isPresent()) {
                    Set<User> users = new HashSet<>();
                    users.add(user.get());
                    gamesRepository.save(new Game(name, price, slots, startDate, length, playground.get(), users));
                    return new ServerResponse();
                }//wrong playground
                return new ServerResponse(Response.PWUE1012);
            }//Wrong user;
            return new ServerResponse(Response.PWUE1003);
        }//start < now
        return new ServerResponse(Response.PWUE1011);
    }

    public ServerResponse joinGame(Long gameId, Long userId) {
        Optional<Game> gameOptional = gamesRepository.findById(gameId);
        if (gameOptional.isPresent()) {
            Game game = gameOptional.get();
            Optional<User> userOptional = usersRepository.findById(userId);
            if (userOptional.isPresent()) {
                Set<User> userSet = game.getUser();
                if (userSet.size() < game.getSlots()) {
                    userSet.add(userOptional.get());
                    game.setUser(userSet);
                    gamesRepository.save(game);
                    return new ServerResponse();
                }
                return new ServerResponse(Response.PWUE1015);
            }
            return new ServerResponse(Response.PWUE1003);
        }
        return new ServerResponse(Response.PWUE1013);
    }

    public ServerResponse cancelGameReservation(Long gameId, Long userId) {
        Optional<Game> gameOptional = gamesRepository.findById(gameId);
        if (gameOptional.isPresent()) {
            Game game = gameOptional.get();
            Optional<User> userOptional = usersRepository.findById(userId);
            if (userOptional.isPresent()) {
                Set<User> userSet = game.getUser();
                if (userSet.contains(userOptional.get())) {
                    userSet.remove(userOptional.get());
                    game.setUser(userSet);
                    gamesRepository.save(game);
                }
                return new ServerResponse(Response.PWUE1014);
            }
            return new ServerResponse(Response.PWUE1003);
        }
        return new ServerResponse(Response.PWUE1013);
    }
}
