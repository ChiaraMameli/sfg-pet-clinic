package org.springframework.sfg.model;

import io.micrometer.core.lang.Nullable;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Pet extends BaseEntity{
    @Column(name = "name")
    @NonNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    @NonNull
    private PetType petType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    @Nullable
    private Set<Visit> visits = new HashSet<>();

    public Pet(Long id, @NonNull String name, Owner owner, @NonNull PetType petType, @Nullable Set<Visit> visits) {
        super(id);
        this.name = name;
        this.owner = owner;
        this.petType = petType;
        this.visits = visits;
    }
}
