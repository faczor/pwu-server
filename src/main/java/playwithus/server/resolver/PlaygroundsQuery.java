package playwithus.server.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import playwithus.server.model.Playground;
import playwithus.server.repository.PlaygroundsRepository;

@Component
@AllArgsConstructor
public class PlaygroundsQuery implements GraphQLQueryResolver {

    private final PlaygroundsRepository playgroundsRepository;

    public Iterable<Playground> findAllPlaygrounds(){
        return playgroundsRepository.findAll();
    }

    public Playground findPlaygroundById(Long playground){
        return playgroundsRepository.findById(playground).orElse(null);
    }
}
