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
    PWUE1007 ("Address already in use"),
    PWUE1008 ("Wrong price value"),
    PWUE1009 ("Wrong slots value"),
    PWUE1010 ("Wrong length value"),
    PWUE1011 ("Wrong date value"),
    PWUE1012 ("Playground not exist"),
    PWUE1013 ("Game not exist"),
    PWUE1014 ("User is not in the game"),
    PWUE1015 ("No free slot in the game"),
    PWUE1016 ("Passwords didn't match"),
    PWUE1017 ("Wrong old password")
    ;

    @Getter
    public String msg;

    Response(String msg) {
            this.msg = msg;
        }
}
