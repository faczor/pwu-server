package playwithus.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "Playgrounds")
@AllArgsConstructor
@NoArgsConstructor
public class Playground {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PlaygroundId", nullable = false)
    private Long playgroundId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "InDoor", nullable = false)
    private boolean inDoor;

    @OneToOne(mappedBy = "playground")
    private Address address;

    @OneToMany(mappedBy = "playground")
    private Set<Game> game;

    public Playground(String name, boolean inDoor, Address address) {
        this.name = name;
        this.inDoor = inDoor;
        this.address = address;
    }
}
