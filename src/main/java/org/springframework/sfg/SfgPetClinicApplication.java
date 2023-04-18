package org.springframework.sfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.sfg.dto.*;
import org.springframework.sfg.model.*;
import org.springframework.sfg.services.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SfgPetClinicApplication implements CommandLineRunner {

	@Autowired
	private OwnerService ownerService;
	@Autowired
	private PetService petService;
	@Autowired
	private VetService vetService;
	@Autowired
	private SpecialityService specialityService;
	@Autowired
	private PetTypeService petTypeService;
	@Autowired
	private VisitService visitService;

	public static void main(String[] args) {
		SpringApplication.run(SfgPetClinicApplication.class, args);
		System.out.println("ok");
	}

	@Override
	public void run(String... args) throws Exception {

		SpecialityDto sd1 = new SpecialityDto(1L, "surgeon");
		SpecialityDto sd2 = new SpecialityDto(2L, "behavioral specialist");

		specialityService.save(sd1);
		specialityService.save(sd2);

		Speciality s1 = SpecialityDto.to(sd1);
		Speciality s2 = SpecialityDto.to(sd2);

		Set<Speciality> ss1 = new HashSet<>();
		ss1.add(s1);

		Set<Speciality> ss2 = new HashSet<>();
		ss1.add(s2);


		PetTypeDto ptd1 = new PetTypeDto(1L,"dog");
		PetTypeDto ptd2 = new PetTypeDto(2L,"cat");
		PetTypeDto ptd3 = new PetTypeDto(3L,"rabbit");
		PetTypeDto ptd4 = new PetTypeDto(4L,"mice");

		petTypeService.savePetType(ptd1);
		petTypeService.savePetType(ptd2);
		petTypeService.savePetType(ptd3);
		petTypeService.savePetType(ptd4);

		OwnerDto od1 = new OwnerDto(1L, "Chiara", "Mameli", "via Pippo", "Torino", "000");
		OwnerDto od2 = new OwnerDto(2L, "Francesco", "Esposito", "via Ciccio", "Napoli", "111");
		OwnerDto od3 = new OwnerDto(3L, "Valeria", "Caria", "via Pluto", "Cagliari", "222");

		ownerService.save(od1);
		ownerService.save(od2);
		ownerService.save(od3);

		VetDto v1 = new VetDto(1L, "Andrea", "Serra", ss1);
		VetDto v2 = new VetDto(2L, "Sabrina", "Molinari", ss2);

		vetService.save(v1);
		vetService.save(v2);

		Owner o1 = OwnerDto.to(od1);
		Owner o2 = OwnerDto.to(od2);

		PetType pt1 = PetTypeDto.to(ptd1);
		PetType pt2 = PetTypeDto.to(ptd2);
		PetType pt3 = PetTypeDto.to(ptd3);
		PetType pt4 = PetTypeDto.to(ptd4);


		PetDto p1 = new PetDto(1L, "Lily", o1, pt2, null);
		PetDto p2 = new PetDto(2L, "Lola", o2, pt1, null);

		petService.save(p1);
		petService.save(p2);


//		Visit vi1 = new Visit(LocalDate.now(), "Visita specialistica", p1);
//		Visit vi2 = new Visit(LocalDate.now(), "Visita di routine", p2);
//
//		visitService.saveVisit(vi1);
//		visitService.saveVisit(vi2);
	}
}
