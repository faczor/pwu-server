package playwithus.server.service;

import playwithus.server.model.User;

public interface ISecurityService {
    public String findLoggedUsername();
    public User findLoggedUser();
    public User authenticate(final String token);
    public void autoLogin(final String username, final String password);
}
