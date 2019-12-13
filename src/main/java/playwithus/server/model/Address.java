package playwithus.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Addresses")
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AddressId", nullable = false)
    private Long addressId;

    @Column(name = "Country", nullable = false)
    private String country;

    @Column(name = "City", nullable = false)
    private String city;

    @Column(name = "ZipCode", nullable = false)
    private String zipCode;

    @Column(name = "Street", nullable = false)
    private String street;

    @Column(name = "Latitude", nullable = false)
    private double latitude;

    @Column(name = "Longitude", nullable = false)
    private double longitude;

    @OneToOne
    @JoinColumn(name = "PlaygroundId", nullable = false)
    private Playground playground;

    public Address(String country, String city, String zipcode, double latitude, double longitude){
        this.country = country;
        this.city = city;
        this.zipCode = zipcode;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
