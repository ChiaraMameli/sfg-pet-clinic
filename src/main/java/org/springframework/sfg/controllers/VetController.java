package org.springframework.sfg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.model.Vet;
import org.springframework.sfg.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class VetController {

    @Autowired
    private VetService vetService;

    @RequestMapping("/vets")
    public String index(Model model){
        List<Vet> vets = vetService.findAllVets();
        model.addAttribute("vets", vets);
        return "vet/index";
    }
}
