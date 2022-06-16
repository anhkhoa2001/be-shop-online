package com.spring.modules.product.controllers.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.modules.product.controllers.dto.PhoneTabDTO;
import com.spring.modules.product.facades.impls.PhoneTabFacade;
import com.spring.modules.product.models.PhoneTabModel;
import com.spring.modules.product.services.PhoneTabService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phone-tab")
public class PhoneTabController extends ATypeManagementRestController<PhoneTabDTO, PhoneTabModel, PhoneTabService, PhoneTabFacade> {

    protected PhoneTabController(final PhoneTabFacade facade) {
        super(facade);
    }
}
