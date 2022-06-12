package com.spring.modules.product.controllers.rest;

import com.spring.modules.product.models.ProductModel;
import com.spring.modules.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/test")
    @ResponseBody
    public List<ProductModel> getAll() {
        return productService.getAll();
    }
}
