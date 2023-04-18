package org.springframework.sfg.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Speciality extends BaseEntity{

    @Column(name = "description")
    @NonNull
    private String description;

    public Speciality(Long id, @NonNull String description) {
        super(id);
        this.description = description;
    }
}
