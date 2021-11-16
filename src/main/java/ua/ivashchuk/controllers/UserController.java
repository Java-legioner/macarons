package ua.ivashchuk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.ivashchuk.dao.UserRepository;
import ua.ivashchuk.domains.Role;
import ua.ivashchuk.domains.User;
import ua.ivashchuk.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    private  UserService userService;



    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userService.findAllUser());
        return "user/userList";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", Role.values());
        return "user/userEdit";

    }

    @PostMapping("/{id}")
    public String userUpdate(@ModelAttribute("user") User user, @PathVariable("id") int id, @RequestParam String[] roles ){
        userService.update(user, id, roles);
        return "redirect:/user";
    }






}
