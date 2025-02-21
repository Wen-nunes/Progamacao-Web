package com.projeto1.CRUD;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
     public String home(){
         return "home";
     }

    @GetMapping("/2")
    public String bios(){
        return "bios";
    }
    @GetMapping("/3")
    public String contatos(){
        return "contatos";
    }
}
