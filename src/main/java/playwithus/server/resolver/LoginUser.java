package playwithus.server.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import playwithus.server.response.ServerResponse;

@Component
@AllArgsConstructor
public class LoginUser implements GraphQLMutationResolver {

    public ServerResponse loginUser(String login, String password){
        return new ServerResponse();
    }
}
