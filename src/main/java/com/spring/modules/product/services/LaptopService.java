package com.spring.modules.product.services;

import com.spring.core.service.ATypeManagementService;
import com.spring.modules.product.models.LaptopModel;
import com.spring.modules.product.repositories.LaptopRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService extends ATypeManagementService<LaptopModel> {

    @Autowired
    public LaptopService(final LaptopRespository laptopRespository) {
        super(laptopRespository);
    }

}
