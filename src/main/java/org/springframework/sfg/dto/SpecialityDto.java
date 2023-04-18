package org.springframework.sfg.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.sfg.model.Speciality;

@Getter
@Setter
@NoArgsConstructor
public class SpecialityDto {
    private Long id;
    private String description;

    public SpecialityDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public static SpecialityDto from(Speciality source){
        return new SpecialityDto(
                source.getId(),
                source.getDescription()
        );
    }

    public static Speciality to(SpecialityDto source){
        return new Speciality(
                source.getId(),
                source.getDescription()
        );
    }
}
