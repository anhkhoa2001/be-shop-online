package com.spring.modules.product.services;

import com.spring.core.service.ATypeManagementService;
import com.spring.modules.category.model.CategoryModel;
import com.spring.modules.product.models.PhoneTabModel;
import com.spring.modules.product.models.ProductModel;
import com.spring.modules.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends ATypeManagementService<ProductModel> {

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        super(productRepository);
    }
}
