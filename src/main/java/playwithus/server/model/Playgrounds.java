package playwithus.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Playgrounds {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PlaygroundId", nullable = false)
    private Long playgroundId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "InDoor", nullable = false)
    private boolean inDoor;

    @OneToOne(mappedBy = "playground")
    private Addresses address;

    @OneToMany(mappedBy = "playground")
    private Set<Games> game;
}
