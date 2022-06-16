package com.spring.modules.category.controller.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.modules.category.controller.dtos.ProductLineDTO;
import com.spring.modules.category.facades.imps.ProductLineFacade;
import com.spring.modules.category.model.ProductLineModel;
import com.spring.modules.category.service.ProductLineService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-line")
public class ProductLineController extends ATypeManagementRestController<ProductLineDTO, ProductLineModel,
                                    ProductLineService, ProductLineFacade> {

    protected ProductLineController(final ProductLineFacade facade) {
            super(facade);
        }
}
