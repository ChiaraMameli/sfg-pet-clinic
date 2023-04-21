package org.springframework.sfg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.dto.OwnerDto;
import org.springframework.sfg.dto.PetDto;
import org.springframework.sfg.dto.PetTypeDto;
import org.springframework.sfg.model.Owner;
import org.springframework.sfg.services.OwnerService;
import org.springframework.sfg.services.PetService;
import org.springframework.sfg.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.List;

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
        List<OwnerDto> owners = ownerService.findAllOwners();
        model.addAttribute("owners", owners);
        return "owner/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) throws Exception{

        OwnerDto owner = ownerService.findOwnerById(id);
        model.addAttribute("owner", owner);

        List<PetDto> ownersPet = petService.findPetByOwnerId((long) id);
        model.addAttribute("pets", ownersPet);

        return "owner/show";
    }

    @GetMapping("/create")
    public String create(Model model){

        OwnerDto newOwner = new OwnerDto();
        model.addAttribute("owner", newOwner);

        return "owner/create";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, Model model) throws Exception{

        OwnerDto odto = ownerService.findOwnerById(id);
        Owner o = OwnerDto.to(odto);
        model.addAttribute("owner", o);

        return "owner/create";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("ownerDto")OwnerDto ownerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/owners/create";
        }

        ownerService.save(ownerDto);

        return "redirect:/owners";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id")Long id) throws Exception{

        OwnerDto ownerDto = ownerService.findOwnerById(id);
        ownerService.delete(ownerDto);

        return "redirect:/owners";
    }

    @GetMapping("{id}/add-pet")
    public String createPet(@PathVariable("id") Long id, Model model) throws Exception{
        //TUTTO QUESTO DOVREBBE STARE IN UN METODO
        List<PetTypeDto> petTypes = petTypeService.findAll();
        model.addAttribute("petTypes", petTypes);

        OwnerDto o = ownerService.findOwnerById(id);
        Owner owner = OwnerDto.to(o);
        model.addAttribute("owner", owner);

        PetDto pet = new PetDto();
        pet.setOwner(owner);
        model.addAttribute("pet", pet);

        return "pet/create";
    }

    @PostMapping("/store-pet")
    public String storePet(@ModelAttribute()PetDto pet){

        petService.save(pet);

        return "redirect:/owners";
    }

    @GetMapping("/find")
    public String findOwner(@RequestParam(name = "q", required = false) String query, Model model) throws Exception{

        List<OwnerDto> owners = ownerService.findyAllByLastName(query);

        if(owners.isEmpty()) throw new Exception("Not Found");

        model.addAttribute("owners", owners);

        return "redirect:/owners";
    }


}
