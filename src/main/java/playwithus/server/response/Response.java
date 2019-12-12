package playwithus.server.response;

import lombok.Getter;

public enum Response {
    FATAL ("Internal server error $0"),
    PWUE1001 ("User with this email exists"),
    PWUE1002 ("Passwords are different"),
    PWUE1003 ("User not exist"),
    PWUE1004 ("Wrong role name"),
    PWUE1005 ("Name is already used"),
    PWUE1006 ("No address in db with this Id"),
    PWUE1007 ("Address already in use")
    ;

    @Getter
    public String msg;

    Response(String msg) {
            this.msg = msg;
        }
}
