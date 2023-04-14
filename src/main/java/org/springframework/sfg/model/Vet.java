package org.springframework.sfg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Vet extends Person {
    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
