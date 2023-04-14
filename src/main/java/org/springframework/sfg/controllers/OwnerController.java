package org.springframework.sfg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.model.Owner;
import org.springframework.sfg.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

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

        return "owner/show";
    }

}
