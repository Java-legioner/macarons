package ua.ivashchuk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.ivashchuk.domains.User;
import ua.ivashchuk.services.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;


    @GetMapping
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "registration";
        if(!userService.addUser(user)) {
            return "registration";
        }
        return "redirect:/login";
    }


}
