package org.springframework.sfg.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.sfg.model.Speciality;
import org.springframework.sfg.model.Vet;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class VetDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<Speciality> specialities;

    public VetDto(Long id, String firstName, String lastName, Set<Speciality> specialities) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialities = specialities;
    }

    public static VetDto from(Vet source){
        return new VetDto(
                source.getId(),
                source.getFirstName(),
                source.getLastName(),
                source.getSpecialities()
        );
    }

    public static Vet to(VetDto source){
        return new Vet(
                source.getId(),
                source.getFirstName(),
                source.getLastName(),
                source.getSpecialities()
        );
    }
}
