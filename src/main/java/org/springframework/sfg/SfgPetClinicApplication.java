package org.springframework.sfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.sfg.model.Owner;
import org.springframework.sfg.model.Pet;
import org.springframework.sfg.model.Vet;
import org.springframework.sfg.services.OwnerService;
import org.springframework.sfg.services.PetService;
import org.springframework.sfg.services.VetService;

@SpringBootApplication
public class SfgPetClinicApplication implements CommandLineRunner {

	@Autowired
	private OwnerService ownerService;
	@Autowired
	private PetService petService;
	@Autowired
	private VetService vetService;

	public static void main(String[] args) {
		SpringApplication.run(SfgPetClinicApplication.class, args);
		System.out.println("ok");
	}

	@Override
	public void run(String... args) throws Exception {
		Owner o1 = new Owner("Chiara", "Mameli");
		Owner o2 = new Owner("Francesco", "Esposito");
		Owner o3 = new Owner("Valeria", "Caria");

		ownerService.save(o1);
		ownerService.save(o2);
		ownerService.save(o3);

		Vet v1 = new Vet("Andrea", "Serra");
		Vet v2 = new Vet("Sabrina", "Molinari");

		vetService.save(v1);
		vetService.save(v2);

		Pet p1 = new Pet("Lily");
		Pet p2 = new Pet("Lola");

		petService.save(p1);
		petService.save(p2);

	}
}
