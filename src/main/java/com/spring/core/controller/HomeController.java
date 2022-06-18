package com.spring.core.controller;

import com.spring.core.config.AuthenticationSystem;
import com.spring.modules.authentication.controllers.dtos.CustomerDTO;
import com.spring.modules.authentication.facades.ERole;
import com.spring.modules.authentication.facades.imps.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private CustomerFacade customerFacade;

    @GetMapping
    public String home(Model model) {
        //islog = true: da dang nhap
        //islog = false: chua dang nhap

        model.addAttribute("isLog", AuthenticationSystem.isLogged());
        String username = AuthenticationSystem.getUsernameCurrent();
        String url = "home";
        CustomerDTO customerDTO = customerFacade.getByUsername(username);
        if(Objects.nonNull(customerDTO)) {
            model.addAttribute("dto", customerDTO);

            if(Objects.equals(customerDTO.getRole(), ERole.ADMIN.toString())) {
                return "redirect:/manage";
            } else {
               return url;
            }
        }

        return "error";
    }

    @GetMapping("/test")
    public String test() {
        return "index1";
    }
}
