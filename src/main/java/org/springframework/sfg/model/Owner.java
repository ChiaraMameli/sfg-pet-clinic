package org.springframework.sfg.model;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor(force = true)
public class Owner extends Person {

    @Column(name = "address")
    @NotBlank(message = "Address field cannot be empty")
    @NotNull
    private String address;

    @Column(name = "city")
    @NotBlank(message = "City field cannot be empty")
    @NotNull
    private String city;

    @Column(name = "telephone")
    @NotBlank(message = "Telephone field cannot be empty")
    @Size(min = 9, max = 10, message = "Telephone size must be between 9 and 10 numbers")
    @Pattern(regexp = "^\\d{10}$")
    @NotNull
    private String telephone;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pet> pets = new HashSet<>();

    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }
}
