package com.spring.modules.category.service;

import com.spring.core.service.ATypeManagementService;
import com.spring.modules.category.model.ManufacturerModel;
import com.spring.modules.category.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerService extends ATypeManagementService<ManufacturerModel> {

    @Autowired
    public ManufacturerService(final ManufacturerRepository manufacturerRepository) {
        super(manufacturerRepository);
    }

}
