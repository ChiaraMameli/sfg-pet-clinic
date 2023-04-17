package org.springframework.sfg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.model.Speciality;
import org.springframework.sfg.model.Vet;
import org.springframework.sfg.services.SpecialityService;
import org.springframework.sfg.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/vets")
public class VetController {

    @Autowired
    private VetService vetService;
    @Autowired
    private SpecialityService specialityService;

    @GetMapping
    public String index(Model model){

        List<Vet> vets = vetService.findAllVets();
        model.addAttribute("vets", vets);

        List<Speciality> specialities = specialityService.findAll();
        model.addAttribute("specialities", specialities);


        return "vet/index";
    }

    @GetMapping("/create")
    public String create(Model model){

        Vet vet = new Vet();
        model.addAttribute("vet", vet);

        List<Speciality> specialities = specialityService.findAll();
        model.addAttribute("specialities", specialities);


        return "vet/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute()Vet vet){

        vetService.save(vet);

        return "redirect:/vets";
    }
}
