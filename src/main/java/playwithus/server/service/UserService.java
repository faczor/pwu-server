package playwithus.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import playwithus.server.Dto.UserDto;
import playwithus.server.model.Users;
import playwithus.server.repository.UsersRepository;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    /*public registerNewAccount(UserDto accountDto){
        Users user = new Users(accountDto.getName(), accountDto.getSurname(), accountDto.getEmail(), accountDto.getPassword(), null, Users.Role.User);
        usersRepository.save(user);
    }*/
}
