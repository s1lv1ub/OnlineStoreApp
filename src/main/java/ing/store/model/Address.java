package ing.store.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min=5, message = "Street name must be at least 5 characters")
    private String street;

    @NotBlank
    @Size(min=5, message = "Building name must be at least 5 characters")
    private String buildinName;

    @NotBlank
    @Size(min=2, message = "City name must be at least 2 characters")
    private String city;

    @NotBlank
    @Size(min=2, message = "Country name must be at least 2 characters")
    private String country;

    @NotBlank
    @Size(min=6, message = "Zip Code name must be at least 2 characters")
    private String zipCode;

    @ToString.Exclude
    @ManyToMany( mappedBy = "addresses")
    private List<User> users;

    public Address(String street, String buildinName, String city, String country, String zipCode) {
        this.street = street;
        this.buildinName = buildinName;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }
}
