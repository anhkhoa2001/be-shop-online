package com.spring.modules.checkout.services;

import com.spring.core.service.ATypeManagementService;
import com.spring.modules.checkout.models.OrderModel;
import com.spring.modules.checkout.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ATypeManagementService<OrderModel> {

    @Autowired
    public OrderService(final OrderRepository repository) {
        super(repository);
    }

}
