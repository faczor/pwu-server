package playwithus.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
@Table(name = "Games")
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GameId", nullable = false)
    private Long gameId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Price", nullable = false)
    private int price;

    @Column(name = "Slots", nullable = false)
    private int slots;

    @Column(name = "Start", nullable = false)
    private Timestamp start;

    @Column(name = "Length", nullable = false)
    private int length;

    @ManyToOne
    @JoinColumn(name = "PlaygroundId", nullable = false)
    private Playground playground;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserId", nullable = false)
    private Set<User> user;

    public Game(String name, int price, int slots, Timestamp start, int length, Playground playground, Set<User> user) {
        this.name = name;
        this.price = price;
        this.slots = slots;
        this.start = start;
        this.length = length;
        this.playground = playground;
        this.user = user;
    }
}
