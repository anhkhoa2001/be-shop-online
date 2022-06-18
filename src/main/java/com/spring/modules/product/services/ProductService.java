package com.spring.modules.product.services;

import com.spring.core.service.ATypeManagementService;
import com.spring.modules.product.models.ProductModel;
import com.spring.modules.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService extends ATypeManagementService<ProductModel> {

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        super(productRepository);
    }

    public List<ProductModel> getByCID(final long cID) {
        try {
            if(CollectionUtils.isEmpty(getAll())) {
                return Collections.emptyList();
            } else {
                List<ProductModel> products = new ArrayList<>();
                getAll().forEach(e -> {
                    if(e.getCategory().getId() == cID) {
                        products.add(e);
                    }
                });
                return products;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
