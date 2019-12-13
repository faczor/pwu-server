package playwithus.server.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import playwithus.server.model.User;
import playwithus.server.repository.UsersRepository;
import playwithus.server.response.Response;
import playwithus.server.response.ServerResponse;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UsersMutation implements GraphQLMutationResolver {

  private final UsersRepository usersRepository;

  @Lazy
  private PasswordEncoder passwordEncoder;

  public ServerResponse changeUserRole(Long userId, String role) {
    if(usersRepository.findById(userId).isPresent()){
      if(role.equals(User.Role.ADMIN) || role.equals(User.Role.USER)){
        User user = usersRepository.findById(userId).get();
        user.setRole(role);
        usersRepository.save(user);
        return new ServerResponse();
      }
      return new ServerResponse(Response.PWUE1004);
    }
    return new ServerResponse(Response.PWUE1003);
  }

  public ServerResponse changePassword(Long userId, String oldPassword, String newPassword, String newMatchPassword){
    if(newMatchPassword.equals(newPassword)){
      Optional<User> userOptional = usersRepository.findById(userId);
      if(userOptional.isPresent()){
        User user = userOptional.get();
        if(user.getPassword().equals(oldPassword)){
          user.setPassword(passwordEncoder.encode(newPassword));
          usersRepository.save(user);
          return new ServerResponse();
        }
        return new ServerResponse(Response.PWUE1017);
      }
      return new ServerResponse(Response.PWUE1003);
    }
    return new ServerResponse(Response.PWUE1016);
  }

  public ServerResponse changeEmail(Long userId, String email){
    Optional<User> userOptional = usersRepository.findById(userId);
    if(userOptional.isPresent()){
      if(usersRepository.findByEmail(email).isPresent()){
        User user = userOptional.get();
        user.setEmail(email);
        usersRepository.save(user);
        return new ServerResponse();
      }
      return new ServerResponse(Response.PWUE1001);
    }
    return new ServerResponse(Response.PWUE1003);
  }
}
