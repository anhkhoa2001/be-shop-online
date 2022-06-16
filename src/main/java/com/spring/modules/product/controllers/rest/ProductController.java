package com.spring.modules.product.controllers.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.modules.product.controllers.dto.ProductDTO;
import com.spring.modules.product.facades.impls.ProductFacade;
import com.spring.modules.product.models.ProductModel;
import com.spring.modules.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController extends ATypeManagementRestController<ProductDTO, ProductModel, ProductService, ProductFacade> {

    protected ProductController(final ProductFacade facade) {
        super(facade);
    }
}
