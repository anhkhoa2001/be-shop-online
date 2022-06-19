package com.spring.core.controller;

import com.spring.modules.authentication.config.AuthenticationSystem;
import com.spring.core.response.EResponse;
import com.spring.modules.authentication.controllers.dtos.CustomerDTO;
import com.spring.modules.authentication.facades.ERole;
import com.spring.modules.authentication.facades.imps.CustomerFacade;
import com.spring.modules.checkout.controllers.dtos.OrderDTO;
import com.spring.modules.checkout.facades.imps.OrderFacade;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/manage")
public class ManageController {

    private final CustomerFacade customerFacade;
    private final OrderFacade orderFacade;

    @Autowired
    public ManageController(final CustomerFacade customerFacade, final OrderFacade orderFacade) {
        this.customerFacade = customerFacade;
        this.orderFacade = orderFacade;
    }

    @GetMapping
    public String manage(Model model) {
        String username = AuthenticationSystem.getUsernameCurrent();
        CustomerDTO customerDTO = null;
        if(!Strings.isBlank(username)) {
            customerDTO = getCustomerFacade().getByUsername(username);
            model.addAttribute("dto", customerDTO);
        }
        if(Objects.isNull(customerDTO)) {
            return "redirect:/login?status=401";
        } else {
            if(customerDTO.getRole().equals(ERole.ADMIN.toString())) {
                String CurrentTime = EResponse.day.format(EResponse.localDate);
                List<OrderDTO> orderDTOByCurrentTime = getOrderFacade().getAllOrdersByCreated(CurrentTime);
                int count = 0, totalQuantity = 0, totalPrice = 0,countNoti = 0;
                try {
                    for(OrderDTO orderDTO : orderDTOByCurrentTime) {
                        count++;
                        totalQuantity += orderDTO.getQuantity();
                        totalPrice += orderDTO.getTotal();
                    }
                    List<OrderDTO> orderDTOS = getOrderFacade().getAll();
                    for(OrderDTO o:orderDTOS) {
                        if(!o.isStatus()) {
                            countNoti++;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    model.addAttribute("count", count);
                    model.addAttribute("totalQuantity", totalQuantity);
                    model.addAttribute("totalPrice", totalPrice);
                    model.addAttribute("countNoti", countNoti);
                    return "manage";
                }
            } else {
                return "redirect:/home";
            }
        }
    }

    public CustomerFacade getCustomerFacade() {
        return customerFacade;
    }

    public OrderFacade getOrderFacade() {
        return orderFacade;
    }
}
