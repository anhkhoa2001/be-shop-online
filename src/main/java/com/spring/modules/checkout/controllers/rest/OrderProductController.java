package com.spring.modules.checkout.controllers.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.modules.checkout.controllers.dtos.OrderProductDTO;
import com.spring.modules.checkout.facades.imps.OrderProductFacade;
import com.spring.modules.checkout.models.OrderProductModel;
import com.spring.modules.checkout.services.OrderProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-product")
public class OrderProductController extends ATypeManagementRestController<OrderProductDTO, OrderProductModel, OrderProductService, OrderProductFacade> {

    protected OrderProductController(final OrderProductFacade facade) {
        super(facade);
    }
}