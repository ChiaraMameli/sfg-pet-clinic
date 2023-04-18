package org.springframework.sfg.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@MappedSuperclass
public class Person extends BaseEntity{

    @Column(name = "first_name")
    @NonNull
    private String firstName;

    @Column(name = "last_name")
    @NonNull
    private String lastName ;

    public Person(Long id, @NonNull String firstName, @NonNull String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
