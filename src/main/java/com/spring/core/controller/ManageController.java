package com.spring.core.controller;

import com.spring.modules.authentication.facades.imps.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    private CustomerFacade customerFacade;

    @GetMapping
    public String manage(HttpServletRequest request, Model model) {
/*        String username = AuthenticationSystem.getUsernameCurrent();
        CustomerDTO customerDTO = null;
        if(!Strings.isBlank(username)) {
            customerDTO = customerFacade.getByUsername(username);
            model.addAttribute("dto", customerDTO);
        }

        if(Objects.isNull(customerDTO)) {
            return "redirect:http://localhost:8080/login";
        } else {
            if(customerDTO.getRole().equals(ERole.ADMIN.toString())) {
*//*                String nowDay = Main.day.format(Main.localDate);
                List<Orders> list = Main.dao.getAllOrdersByCreated(nowDay);
                int count = 0, totalQuantity = 0, totalPrice = 0;
                for(Orders orders : list) {
                    count++;
                    totalQuantity += orders.getQuantity();
                    totalPrice += orders.getTotal();
                }
                int countNoti = 0;
                List<Orders> list2 = Main.dao.getAllOrders();
                for(Orders o:list2) {
                    if(!o.isStatus()) {
                        countNoti++;
                    }
                }
                model.addAttribute("count", count);
                model.addAttribute("totalQuantity", totalQuantity);
                model.addAttribute("totalPrice", totalPrice);
                model.addAttribute("countNoti", countNoti);*//*

                return "manage";
            } else {
                return "redirect:http://localhost:8080/home";
            }
        }*/

        return "manage";
    }
}
