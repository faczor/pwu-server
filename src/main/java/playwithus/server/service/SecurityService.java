package playwithus.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import playwithus.server.model.User;
import playwithus.server.repository.UsersRepository;

import java.util.Base64;

public class SecurityService implements ISecurityService {

    @Autowired
    private DaoAuthenticationProvider daoAuthenticationProvider;

    private UsersRepository usersRepository;

    @Override
    public String findLoggedUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails instanceof User) {
            return ((User) userDetails).getEmail();
        }
        return null;
    }

    @Override
    public User findLoggedUser() {
        return usersRepository.findByEmail(findLoggedUsername()).orElse(null);
    }

    @Override
    public User authenticate(String token) {
        final String encoded = token.split(" ")[1];
        final String email = new String(Base64.getMimeDecoder().decode(encoded)).split(":")[0];
        return usersRepository.findByEmail(email).orElse(null);
    }

    @Override
    public void autoLogin(final String username, final String password) {
        User user = usersRepository.findByEmail(username).orElse(null);
        /*final UserDetails userDetails = new User(user.getName(), d)
        final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        daoAuthenticationProvider.authenticate(usernamePasswordAuthenticationToken);
        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }*/
    }
}
