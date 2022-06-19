package com.spring.modules.checkout.controllers;

import com.spring.modules.authentication.config.AuthenticationSystem;
import com.spring.modules.authentication.controllers.dtos.CustomerDTO;
import com.spring.modules.authentication.facades.imps.CustomerFacade;
import com.spring.modules.product.controllers.dto.ProductDTO;
import com.spring.modules.product.facades.impls.ProductFacade;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping("/check-out")
public class CheckoutController {

    @Autowired
    private CustomerFacade customerFacade;

    @Autowired
    private ProductFacade productFacade;

    @GetMapping
    public String checkout(Model model, HttpServletRequest request) {
        model.addAttribute("isLog", AuthenticationSystem.isLogged());
        String username = AuthenticationSystem.getUsernameCurrent();
        CustomerDTO customerDTO = getCustomerFacade().getByUsername(username);
        if(Objects.nonNull(customerDTO)) {
            model.addAttribute("dto", customerDTO);
        } else {
            if(!Strings.isBlank(request.getParameter("code"))) {
                ProductDTO productDTO = getProductFacade().getByCode(request.getParameter("code"));
                model.addAttribute("product", productDTO);
            }
        }

        return "checkout";
    }

    public CustomerFacade getCustomerFacade() {
        return customerFacade;
    }

    public ProductFacade getProductFacade() {
        return productFacade;
    }
}
