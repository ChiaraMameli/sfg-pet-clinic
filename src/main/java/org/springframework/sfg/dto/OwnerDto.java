package org.springframework.sfg.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.sfg.model.Owner;
import org.springframework.sfg.model.Pet;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class OwnerDto {
    private Long id;
    private String firstName;
    private String lastName ;
    private String address;
    private String city;
    private String telephone;
    private Set<Pet> pets = new HashSet<>();

    public OwnerDto(Long id, String firstName, String lastName, String address, String city, String telephone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }


    public static OwnerDto from(Owner source) {
        return new OwnerDto(
                source.getId(),
                source.getFirstName(),
                source.getLastName(),
                source.getAddress(),
                source.getCity(),
                source.getTelephone()
        );
    }

    public static Owner to(OwnerDto source){
        return new Owner(
                source.getId(),
                source.getFirstName(),
                source.getLastName(),
                source.getAddress(),
                source.getCity(),
                source.getTelephone()

        );
    }

    public String getFullName(){
        return getFirstName() + " " + getLastName();
    }

}
