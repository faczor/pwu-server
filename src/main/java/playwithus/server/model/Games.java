package playwithus.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Games {

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
    private Date start;

    @Column(name = "Length", nullable = false)
    private int length;

    @ManyToOne
    @JoinColumn(name = "PlaygroundId", nullable = false)
    private Playgrounds playground;

    @ManyToOne
    @JoinColumn(name = "UserId", nullable = false)
    private Users user;
}
