package ua.ivashchuk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.ivashchuk.dao.UserRepository;


@Controller
public class MainController {

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model, String email) {
        model.addAttribute("user", userRepository.findByEmail(email));

        return "home";
    }


}
