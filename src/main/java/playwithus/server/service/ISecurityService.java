package playwithus.server.service;

import playwithus.server.model.Users;

public interface ISecurityService {
    public String findLoggedUsername();
    public Users findLoggedUser();
    public Users authenticate(final String token);
    public void autoLogin(final String username, final String password);
}
