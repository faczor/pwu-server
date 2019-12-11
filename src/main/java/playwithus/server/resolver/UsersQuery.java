package playwithus.server.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import playwithus.server.model.Users;
import playwithus.server.repository.UsersRepository;

@Component
@AllArgsConstructor
public class UsersQuery implements GraphQLQueryResolver {

  private final UsersRepository usersRepository;

  public Iterable<Users> findAllUsers(){
    return usersRepository.findAll();
  }
}
