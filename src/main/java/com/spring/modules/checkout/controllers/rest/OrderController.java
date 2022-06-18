package com.spring.modules.checkout.controllers.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.modules.checkout.controllers.dtos.OrderDTO;
import com.spring.modules.checkout.facades.imps.OrderFacade;
import com.spring.modules.checkout.models.OrderModel;
import com.spring.modules.checkout.services.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController extends ATypeManagementRestController<OrderDTO, OrderModel, OrderService, OrderFacade> {

    protected OrderController(final OrderFacade facade) {
        super(facade);
    }
}
