package playwithus.server.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId", nullable = false)
    private Long userId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Role", nullable = false)
    private String role;

    @OneToMany(mappedBy = "user")
    private Set<Games> games;

    public Users(String name, String surname, String email, String password, String phone, Role role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = decodeRole(role);
    }
    private String decodeRole(Role roleName) {
        switch (roleName) {
            case Admin:
                return "Admin";
            case User:
                return "User";
            default:
                return "RoleId error";
        }
    }

    public enum Role {
        Admin,
        User
    }
}
