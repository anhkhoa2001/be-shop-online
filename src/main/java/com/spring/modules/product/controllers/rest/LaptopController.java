package com.spring.modules.product.controllers.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.modules.product.controllers.dto.LaptopDTO;
import com.spring.modules.product.facades.impls.LaptopFacade;
import com.spring.modules.product.models.LaptopModel;
import com.spring.modules.product.services.LaptopService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/laptop")
public class LaptopController extends ATypeManagementRestController<LaptopDTO, LaptopModel, LaptopService, LaptopFacade> {

    protected LaptopController(final LaptopFacade facade) {
        super(facade);
    }
}
