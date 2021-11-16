package ua.ivashchuk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.ivashchuk.domains.Cupcake;
import ua.ivashchuk.dto.CupcakeDTOHelper;
import ua.ivashchuk.services.CupcakeService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

@Controller
@RequestMapping("/cupcakes")
public class CupcakeController {

    private final CupcakeService cupcakeService;

    @Autowired
    public CupcakeController(CupcakeService cupcakeService){
        this.cupcakeService = cupcakeService;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("cupcakes", cupcakeService.findAllCupcakes());
        return "cupcake/cupcakes";
    }

    @GetMapping("/{id}")
    public String cupcake(@PathVariable("id") Integer id, Model model){
        model.addAttribute("cupcake", cupcakeService.findById(id));
        return "cupcake/cupcake";
    }

    @GetMapping("/new")
    public String newCupcake(@ModelAttribute("cupcake") Cupcake cupcake){
        return "cupcake/new";
    }

    @PostMapping
    public String createCupcake(
            @RequestParam MultipartFile image,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Double price
    ) throws IOException {
        cupcakeService.save(CupcakeDTOHelper.createEntity(image, name, description, price));
        return "redirect:/cupcakes";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model){
        model.addAttribute("cupcake", cupcakeService.findById(id));
        return "cupcake/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("cupcake") Cupcake cupcake, @PathVariable("id") Integer id){
        cupcakeService.update(id, cupcake);
        return "redirect:/cupcakes";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id, Cupcake cupcake){
        cupcakeService.delete(cupcake);
        return "redirect:/cupcakes";
    }


}
