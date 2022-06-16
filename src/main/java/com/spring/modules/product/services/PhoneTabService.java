package com.spring.modules.product.services;

import com.spring.core.service.ATypeManagementService;
import com.spring.modules.product.models.PhoneTabModel;
import com.spring.modules.product.repositories.PhoneTabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneTabService extends ATypeManagementService<PhoneTabModel> {

    @Autowired
    public PhoneTabService(final PhoneTabRepository phoneTabRepository) {
        super(phoneTabRepository);
    }

}
