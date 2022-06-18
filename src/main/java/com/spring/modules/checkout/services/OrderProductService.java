package com.spring.modules.checkout.services;

import com.spring.core.service.ATypeManagementService;
import com.spring.modules.checkout.models.OrderProductModel;
import com.spring.modules.checkout.repositories.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderProductService extends ATypeManagementService<OrderProductModel> {

    @Autowired
    public OrderProductService(final OrderProductRepository repository) {
        super(repository);
    }

    public List<OrderProductModel> getByOrderID(final int oid) {
        List<OrderProductModel> orderProducts = new ArrayList<>();
        super.getAll().forEach(e -> {
            if(e.getOrders().getId() == oid) {
                orderProducts.add(e);
            }
        });
        return orderProducts;
    }
}
