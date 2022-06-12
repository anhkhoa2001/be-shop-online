package com.spring.modules.product.services;

import com.spring.contants.service.ITypeManagementService;
import com.spring.modules.product.models.ProductModel;
import com.spring.modules.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ITypeManagementService<ProductModel, ProductRepository> {

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        super(productRepository);
    }

}
