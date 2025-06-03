package com.example.projetoarduino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeControlle {
    @GetMapping("/")
    public String retonarIndex() {
        return "index";
    }
}
