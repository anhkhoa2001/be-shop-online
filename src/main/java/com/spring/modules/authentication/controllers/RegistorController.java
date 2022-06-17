package com.spring.modules.authentication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registor")
public class RegistorController {

    @GetMapping
    public String registorPage() {
        return "registor";
    }
}
