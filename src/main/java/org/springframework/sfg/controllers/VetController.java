package org.springframework.sfg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.dto.SpecialityDto;
import org.springframework.sfg.dto.VetDto;
import org.springframework.sfg.model.Vet;
import org.springframework.sfg.services.SpecialityService;
import org.springframework.sfg.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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

        List<VetDto> vets = vetService.findAllVets();
        model.addAttribute("vets", vets);

        List<SpecialityDto> specialities = specialityService.findAll();
        model.addAttribute("specialities", specialities);

        return "vet/index";
    }

    @GetMapping("/create")
    public String create(Model model){

        VetDto vet = new VetDto();
        model.addAttribute("vet", vet);

        List<SpecialityDto> specialities = specialityService.findAll();
        model.addAttribute("specialities", specialities);


        return "vet/create";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute() VetDto vet, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/vets/create";
        }

        vetService.save(vet);

        return "redirect:/vets";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable("id")Long id, Model model) throws Exception{

        VetDto dto = vetService.findVetById(id);
        Vet vet = VetDto.to(dto);
        model.addAttribute("vet", vet);

        List<SpecialityDto> specialities = specialityService.findAll();
        model.addAttribute("specialities", specialities);

        return "vet/create";
    }
}
