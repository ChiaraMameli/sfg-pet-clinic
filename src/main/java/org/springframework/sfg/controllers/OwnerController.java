package org.springframework.sfg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.model.Owner;
import org.springframework.sfg.model.Pet;
import org.springframework.sfg.model.PetType;
import org.springframework.sfg.services.OwnerService;
import org.springframework.sfg.services.PetService;
import org.springframework.sfg.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;
    @Autowired
    private PetService petService;
    @Autowired
    private PetTypeService petTypeService;

    @GetMapping
    public String index(Model model){
        List<Owner> owners = ownerService.findAllOwnsers();
        model.addAttribute("owners", owners);

        return "owner/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model){

        Owner owner = ownerService.findOwnerById(id);
        model.addAttribute("owner", owner);

        List<Pet> ownersPet = petService.findPetByOwnerId((long) id);
        model.addAttribute("pets", ownersPet);

        return "owner/show";
    }

    @GetMapping("/create")
    public String create(Model model){

        Owner newOwner = new Owner();
        model.addAttribute("owner", newOwner);

        return "owner/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute()Owner owner){

        ownerService.save(owner);

        return "redirect:/owners";
    }

    @GetMapping("{id}/add-pet")
    public String createPet(@PathVariable("id") Long id, Model model){

        List<PetType> petTypes = petTypeService.findAll();
        model.addAttribute("petTypes", petTypes);

        Owner owner = ownerService.findOwnerById(id);
        model.addAttribute("owner", owner);

        Pet pet = new Pet();
        pet.setOwner(owner);
        model.addAttribute("pet", pet);

        return "pet/create";
    }

    @PostMapping("/store-pet")
    public String storePet(@ModelAttribute() Pet pet){

        petService.save(pet);

        return "redirect:/owners";
    }



}
