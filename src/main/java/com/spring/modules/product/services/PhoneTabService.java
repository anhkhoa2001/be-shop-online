package com.spring.modules.product.services;

import com.spring.core.service.ATypeManagementService;
import com.spring.modules.product.models.PhoneTabModel;
import com.spring.modules.product.models.ProductModel;
import com.spring.modules.product.repositories.PhoneTabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneTabService extends ATypeManagementService<PhoneTabModel> {

    @Autowired
    public PhoneTabService(final PhoneTabRepository phoneTabRepository) {
        super(phoneTabRepository);
    }

    public List<PhoneTabModel> getByCmID(final long cmID) {
        List<PhoneTabModel> phoneTabs = new ArrayList<>();

        getAll().forEach(e -> {
            if(e.getCategory().getProductLine().getId() == cmID) {
                phoneTabs.add(e);
            }
        });
        return phoneTabs;
    }

    public List<PhoneTabModel> getByCID(final long cID) {
        List<PhoneTabModel> phoneTabs = new ArrayList<>();

        getAll().forEach(e -> {
            if(e.getCategory().getId() == cID) {
                phoneTabs.add(e);
            }
        });
        return phoneTabs;
    }
}
