package com.spring.modules.category.service;

import com.spring.core.service.ATypeManagementService;
import com.spring.modules.category.model.ProductLineModel;
import com.spring.modules.category.repository.ProductLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductLineService  extends ATypeManagementService<ProductLineModel> {

    @Autowired
    public ProductLineService(final ProductLineRepository productLineRepository) {
        super(productLineRepository);
    }

}
