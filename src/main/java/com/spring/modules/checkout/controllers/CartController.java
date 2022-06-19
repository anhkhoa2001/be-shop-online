package com.spring.modules.checkout.controllers;

import com.spring.modules.authentication.config.AuthenticationSystem;
import com.spring.modules.authentication.controllers.dtos.CustomerDTO;
import com.spring.modules.authentication.facades.imps.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CustomerFacade customerFacade;

    @GetMapping
    public String cart(Model model) {
        model.addAttribute("isLog", AuthenticationSystem.isLogged());
        String username = AuthenticationSystem.getUsernameCurrent();
        CustomerDTO customerDTO = customerFacade.getByUsername(username);
        if(Objects.nonNull(customerDTO)) {
            model.addAttribute("dto", customerDTO);
        }
        return "cart";
    }
}
