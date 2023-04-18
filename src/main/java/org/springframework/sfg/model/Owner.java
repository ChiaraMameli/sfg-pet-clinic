package org.springframework.sfg.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor(force = true)
public class Owner extends Person {

    @Column(name = "address")
    @NonNull
    private String address;

    @Column(name = "city")
    @NonNull
    private String city;

    @Column(name = "telephone")
    @NonNull
    private String telephone;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Pet> pets = new HashSet<>();

    public Owner(Long id, @NonNull String firstName, @NonNull String lastName, @NonNull String address, @NonNull String city, @NonNull String telephone) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }
}
