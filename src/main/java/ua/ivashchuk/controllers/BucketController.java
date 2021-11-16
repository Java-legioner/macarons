package ua.ivashchuk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.ivashchuk.domains.Bucket;
import ua.ivashchuk.domains.Cupcake;
import ua.ivashchuk.domains.Macaron;
import ua.ivashchuk.domains.User;
import ua.ivashchuk.services.BucketService;
import ua.ivashchuk.services.CupcakeService;
import ua.ivashchuk.services.MacaronService;
import ua.ivashchuk.services.UserService;


import java.util.Date;

@Controller
public class BucketController {

    private final BucketService bucketService;
    private final UserService userService;
    private final CupcakeService cupcakeService;
    private final MacaronService macaronService;
    @Autowired
    public BucketController(BucketService bucketService, UserService userService, CupcakeService cupcakeService, MacaronService macaronService){
        this.bucketService = bucketService;
        this.userService = userService;
        this.cupcakeService = cupcakeService;
        this.macaronService = macaronService;
    }

    @GetMapping("/buckets")
    public String getAllItems(Model model){
        model.addAttribute("bucketItems", bucketService.getAll());
        return "bucket/bucket";
    }

    @PostMapping("/bucket")
    public String create(Model model, @RequestParam String cupcakeId){
        Cupcake cupcake = cupcakeService.findById(Integer.parseInt(cupcakeId));
//        Macaron macaron = macaronService.findById(Integer.parseInt(macaronId));

        Bucket bucket = new Bucket();
        bucket.setCupcake(cupcake);
//        bucket.setMacaron(macaron);
        bucket.setPurchaseDate(new Date());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user =  userService.findByUsername(username);
        bucket.setUser(user);

        bucketService.add(bucket);
        model.addAttribute("bucketItems", bucketService.getAll());
        return "bucket/bucket";
    }

//    @PostMapping("/bucket1")
//    public String createMacaron(Model model, @RequestParam String macaronId){
//
//        Macaron macaron = macaronService.findById(Integer.parseInt(macaronId));
//
//        Bucket bucket = new Bucket();
//
//       bucket.setMacaron(macaron);
//       bucket.setPurchaseDate(new Date());
//
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName();
//        User user =  userService.findByUsername(username);
//        bucket.setUser(user);
//
//        bucketService.add(bucket);
//        model.addAttribute("bucketItems", bucketService.getAll());
//        return "bucket/bucket";
//    }





}
