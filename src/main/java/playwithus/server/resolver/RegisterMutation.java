package playwithus.server.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import playwithus.server.Dto.UserDto;
import playwithus.server.model.Users;
import playwithus.server.repository.UsersRepository;
import playwithus.server.response.ServerResponse;

@Component
@AllArgsConstructor
public class RegisterMutation implements GraphQLMutationResolver {

    @Lazy
    private PasswordEncoder  passwordEncoder;

    private final UsersRepository usersRepository;

    public ServerResponse registerUser(UserDto input){
        if(input.getPassword().equals(input.getMatchingPassword())) {
            if (usersRepository.findByEmail(input.getEmail()).isEmpty()) {
                Users user = new Users(input.getName(), input.getSurname(), input.getEmail(), passwordEncoder.encode(input.getPassword()), null, Users.Role.User);
                usersRepository.save(user);
                return new ServerResponse();
            }
            return new ServerResponse("PWUE1002");
        }
        return new ServerResponse("PWUE1001");
    }
}
