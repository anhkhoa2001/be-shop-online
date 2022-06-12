package com.spring.modules.product.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/test1")
    public String home() {
        return "index1";
    }
}
