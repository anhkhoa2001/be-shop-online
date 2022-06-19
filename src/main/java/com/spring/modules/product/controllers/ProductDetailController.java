package com.spring.modules.product.controllers;

import com.spring.modules.authentication.config.AuthenticationSystem;
import com.spring.modules.authentication.controllers.dtos.CustomerDTO;
import com.spring.modules.authentication.facades.imps.CustomerFacade;
import com.spring.modules.product.controllers.dto.LaptopDTO;
import com.spring.modules.product.controllers.dto.PhoneTabDTO;
import com.spring.modules.product.facades.impls.LaptopFacade;
import com.spring.modules.product.facades.impls.PhoneTabFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class ProductDetailController {

    @Autowired
    private CustomerFacade customerFacade;

    @Autowired
    private PhoneTabFacade phoneTabFacade;

    @Autowired
    private LaptopFacade laptopFacade;

    @GetMapping(value = "/home/product-detail")
    public String search(HttpServletRequest request, Model model, @RequestParam String code) {

        model.addAttribute("isLog", AuthenticationSystem.isLogged());
        String username = AuthenticationSystem.getUsernameCurrent();
        CustomerDTO customerDTO = customerFacade.getByUsername(username);
        if(Objects.nonNull(customerDTO)) {
            model.addAttribute("dto", customerDTO);
        }

        try {
            PhoneTabDTO phoneTabDTO = phoneTabFacade.getByCode(code);
            if(Objects.isNull(phoneTabDTO)) {
                LaptopDTO laptopDTO = laptopFacade.getByCode(code);
                model.addAttribute("product", laptopDTO);
            } else {
                model.addAttribute("product", phoneTabDTO);
            }

            return "product-detail";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }
}