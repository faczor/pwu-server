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
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class GamesMutation implements GraphQLMutationResolver {

    private final GamesRepository gamesRepository;

    private final PlaygroundsRepository playgroundsRepository;

    private final UsersRepository usersRepository;

    public ServerResponse addGame(String name, int price, int slots, Timestamp start, int length, Long playgroundId, Long userId) {
        if (price > 0)
            return new ServerResponse(Response.PWUE1008);
        if (slots > 0)
            return new ServerResponse(Response.PWUE1009);
        if (length < 0)
            return new ServerResponse(Response.PWUE1010);
        if (start.after(new Timestamp(System.currentTimeMillis()))) {
            Optional<User> user = usersRepository.findById(userId);
            if (user.isPresent()) {
                Optional<Playground> playground = playgroundsRepository.findById(playgroundId);
                if (playground.isPresent()) {
                    gamesRepository.save(new Game(name, price, slots, start, length, playground.get(), user.get()));
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
                List<User> userList = game.getUser();
                if (userList.size() < game.getSlots()) {
                    userList.add(userOptional.get());
                    game.setUser(userList);
                    gamesRepository.save(game);
                }//No slots available
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
                List<User> userList = game.getUser();
                if (userList.contains(userOptional.get())) {
                    userList.remove(userOptional.get());
                    game.setUser(userList);
                    gamesRepository.save(game);
                }//User is in game;
            }
            return new ServerResponse(Response.PWUE1003);
        }
        return new ServerResponse(Response.PWUE1013);
    }
}
