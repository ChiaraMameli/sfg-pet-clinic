package org.springframework.sfg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.model.Speciality;
import org.springframework.sfg.services.SpecialityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/specialities")
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @GetMapping("/create")
    public String create(Model model){

        Speciality speciality = new Speciality();
        model.addAttribute(speciality);

        return "speciality/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute()Speciality speciality){

        specialityService.saveSpeciality(speciality);

        return "redirect:/vets";
    }
}
