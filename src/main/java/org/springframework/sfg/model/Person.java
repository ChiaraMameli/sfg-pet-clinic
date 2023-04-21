package org.springframework.sfg.model;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@MappedSuperclass
public class Person extends BaseEntity{

    @Column(name = "first_name")
    @NotBlank(message = "First name field cannot be empty")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last Name field cannot be empty")
    @NotNull
    private String lastName ;

    public Person(Long id, @NonNull String firstName, @NonNull String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
