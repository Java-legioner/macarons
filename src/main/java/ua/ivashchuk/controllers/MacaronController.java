package ua.ivashchuk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.ivashchuk.domains.Macaron;
import ua.ivashchuk.services.MacaronService;


@Controller
@RequestMapping("/macarons")
public class MacaronController {

    private final MacaronService macaronService;

    @Autowired
    public MacaronController(MacaronService macaronService){
        this.macaronService = macaronService;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("macarons", macaronService.findAllMacaron() );
        return "macaron/macarons";
    }

    @GetMapping("/{id}")
    public String macaron(@PathVariable("id") int id, Model model){
            model.addAttribute("macaron", macaronService.findById(id));
        return "macaron/macaron";
    }

//    @GetMapping("/new")
//    public String newMacaron(Model model){
//        model.addAttribute("macaron", new Macaron());
//        return "macaron/new";
//    }

    // 2-й спосіб написання Get метода на створення нового запису в базу

    @GetMapping("/new")
    public String newMacaron(@ModelAttribute ("macaron") Macaron macaron){
        return "macaron/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("macaron") Macaron macaron){
        macaronService.save(macaron);
        return "redirect:/macarons";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("macaron", macaronService.findById(id));
        return "macaron/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("macaron") Macaron macaron, @PathVariable("id") int id){
        macaronService.update(id, macaron);
        return "redirect:/macarons";
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id")int id, Macaron macaron){
        macaronService.delete(macaron);
        return "redirect:/macarons";
    }





}
