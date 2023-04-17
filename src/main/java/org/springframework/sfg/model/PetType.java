package org.springframework.sfg.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetType extends BaseEntity{

    @Column(name = "name")
    @NonNull
    private String name;
}
