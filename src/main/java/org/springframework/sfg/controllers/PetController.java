package org.springframework.sfg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.model.Pet;
import org.springframework.sfg.model.PetType;
import org.springframework.sfg.services.PetService;
import org.springframework.sfg.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private PetTypeService petTypeService;

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model){

        Optional<Pet> pet = petService.findPetById(id);
        model.addAttribute("pet", pet.get());

        PetType petType = pet.get().getPetType();
        model.addAttribute(petType);

        return "pet/show";
    }
}
