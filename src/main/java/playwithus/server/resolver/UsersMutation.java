package playwithus.server.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import playwithus.server.model.User;
import playwithus.server.repository.UsersRepository;
import playwithus.server.response.ServerResponse;

@Component
@AllArgsConstructor
public class UsersMutation implements GraphQLMutationResolver {

  public UsersRepository usersRepository;

  public ServerResponse addUser(){
    return new ServerResponse();
  }

  public ServerResponse changeUserRole(Long userId, String role) {
    if(usersRepository.findById(userId).isPresent()){
      if(role.equals(User.Role.ADMIN) || role.equals(User.Role.USER)){
        User user = usersRepository.findById(userId).get();
        user.setRole(role);
        usersRepository.save(user);
        return new ServerResponse();
      }//Wrong role

    }//User not exists
    return new ServerResponse();
  }
}
