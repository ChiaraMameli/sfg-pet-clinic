package org.springframework.sfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.sfg.model.*;
import org.springframework.sfg.services.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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

		Speciality s1 = new Speciality("surgeon");
		Speciality s2 = new Speciality("behavioral specialist");

		specialityService.saveSpeciality(s1);
		specialityService.saveSpeciality(s2);

		Set<Speciality> ss1 = new HashSet<>();
		ss1.add(s1);

		Set<Speciality> ss2 = new HashSet<>();
		ss1.add(s2);


		PetType pt1 = new PetType("dog");
		PetType pt2 = new PetType("cat");
		PetType pt3 = new PetType("rabbit");
		PetType pt4 = new PetType("mice");

		petTypeService.savePetType(pt1);
		petTypeService.savePetType(pt2);
		petTypeService.savePetType(pt3);
		petTypeService.savePetType(pt4);

		Owner o1 = new Owner("Chiara", "Mameli", "via Pippo", "Torino", "000");
		Owner o2 = new Owner("Francesco", "Esposito", "via Ciccio", "Napoli", "111");
		Owner o3 = new Owner("Valeria", "Caria", "via Pluto", "Cagliari", "222");

		ownerService.save(o1);
		ownerService.save(o2);
		ownerService.save(o3);

		Vet v1 = new Vet("Andrea", "Serra", ss1);
		Vet v2 = new Vet("Sabrina", "Molinari", ss2);

		vetService.save(v1);
		vetService.save(v2);

		Pet p1 = new Pet("Lily", o1, pt2, null);
		Pet p2 = new Pet("Lola", o2, pt1, null);

		petService.save(p1);
		petService.save(p2);


		Visit vi1 = new Visit(LocalDate.now(), "Visita specialistica", p1);
		Visit vi2 = new Visit(LocalDate.now(), "Visita di routine", p2);

		visitService.saveVisit(vi1);
		visitService.saveVisit(vi2);
	}
}
