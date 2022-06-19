package com.spring.modules.checkout.services;

import com.spring.core.service.ATypeManagementService;
import com.spring.modules.checkout.controllers.dtos.OrderDTO;
import com.spring.modules.checkout.models.OrderModel;
import com.spring.modules.checkout.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class OrderService extends ATypeManagementService<OrderModel> {

    @Autowired
    public OrderService(final OrderRepository repository) {
        super(repository);
    }


    public List<OrderModel> getAllOrdersByCreated(String timer) {
        List<OrderModel> orders = new ArrayList<>();
        for(OrderModel o : getAll()) {
            if(o.getCreated().equals(timer)) {
                orders.add(o);
            }
        }

        return orders;
    }

    public List<OrderModel> getOrderLimit(final int count) {
        List<OrderModel> orders = getAll();
        Collections.sort(orders, new Comparator<OrderModel>() {
            @Override
            public int compare(OrderModel p1, OrderModel p2) {
                return Integer.compare(p2.getTotal(), p1.getTotal());
            }
        });

        return orders.size() <= count ? orders : orders.subList(0, count);
    }
}
