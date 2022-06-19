package com.spring.modules.product.controllers;

import com.spring.modules.authentication.config.AuthenticationSystem;
import com.spring.modules.authentication.controllers.dtos.CustomerDTO;
import com.spring.modules.authentication.facades.imps.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class ProductsController {

    @Autowired
    private CustomerFacade customerFacade;

    @GetMapping(value = "/home/products")
    public String products(HttpServletRequest request, Model model) {
        model.addAttribute("isLog", AuthenticationSystem.isLogged());

        String username = AuthenticationSystem.getUsernameCurrent();
        CustomerDTO customerDTO = customerFacade.getByUsername(username);
        if(Objects.nonNull(customerDTO)) {
            model.addAttribute("dto", customerDTO);
        }
        model.addAttribute("loadmore", false);
        return "list-product";
    }
}
