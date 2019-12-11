package playwithus.server.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import playwithus.server.repository.UsersRepository;
import playwithus.server.response.ServerResponse;

@Component
@AllArgsConstructor
public class UsersMutation implements GraphQLMutationResolver {

  public UsersRepository usersRepository;

  public ServerResponse addUser(){
    return new ServerResponse();
  }
}
