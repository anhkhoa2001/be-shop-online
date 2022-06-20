package com.spring.modules.category.controller.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.modules.category.controller.dtos.ManufacturerDTO;
import com.spring.modules.category.facades.imps.ManufacturerFacade;
import com.spring.modules.category.model.ManufacturerModel;
import com.spring.modules.category.service.ManufacturerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manu")
public class ManufacturerRestController extends ATypeManagementRestController<ManufacturerDTO, ManufacturerModel,
                                            ManufacturerService, ManufacturerFacade> {

    protected ManufacturerRestController(final ManufacturerFacade facade) {
        super(facade);
    }

}