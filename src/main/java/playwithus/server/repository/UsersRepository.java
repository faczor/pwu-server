package playwithus.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import playwithus.server.model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {}
