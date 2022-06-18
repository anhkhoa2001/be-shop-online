package com.spring.modules.product.services;

import com.spring.core.service.ATypeManagementService;
import com.spring.modules.product.models.LaptopModel;
import com.spring.modules.product.models.PhoneTabModel;
import com.spring.modules.product.repositories.LaptopRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LaptopService extends ATypeManagementService<LaptopModel> {

    @Autowired
    public LaptopService(final LaptopRespository laptopRespository) {
        super(laptopRespository);
    }

    public List<LaptopModel> getByCmID(final long cmID) {
        List<LaptopModel> laptops = new ArrayList<>();

        getAll().forEach(e -> {
            if(e.getCategory().getProductLine().getId() == cmID) {
                laptops.add(e);
            }
        });
        return laptops;
    }

    public List<LaptopModel> getByCID(final long cID) {
        List<LaptopModel> laptops = new ArrayList<>();

        getAll().forEach(e -> {
            if(e.getCategory().getId() == cID) {
                laptops.add(e);
            }
        });
        return laptops;
    }
}
