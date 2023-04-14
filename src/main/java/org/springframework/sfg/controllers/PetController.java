package org.springframework.sfg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.model.Pet;
import org.springframework.sfg.services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

    @RequestMapping("/pets")
    public String index(Model model){
        List<Pet> pets = petService.findAllPets();
        model.addAttribute("pets", pets);
        return "pet/index";
    }

}
