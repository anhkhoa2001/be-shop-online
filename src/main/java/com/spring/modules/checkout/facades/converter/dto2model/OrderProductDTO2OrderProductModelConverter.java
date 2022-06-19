package com.spring.modules.checkout.facades.converter.dto2model;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.modules.category.facades.converters.dto2model.CategoryDTO2CategoryModelConverter;
import com.spring.modules.category.service.CategoryService;
import com.spring.modules.checkout.controllers.dtos.OrderProductDTO;
import com.spring.modules.checkout.models.OrderProductModel;
import com.spring.modules.checkout.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OrderProductDTO2OrderProductModelConverter extends ADTO2ModelConverter<OrderProductDTO, OrderProductModel> {

    private final CategoryDTO2CategoryModelConverter categoryDTO2CategoryModel;
    private final OrderService orderService;
    private final CategoryService categoryService;

    @Autowired
    public OrderProductDTO2OrderProductModelConverter(final CategoryDTO2CategoryModelConverter categoryDTO2CategoryModel,
                                                      final OrderService orderService,
                                                      final CategoryService categoryService) {
        super(new OrderProductModel());
        this.categoryDTO2CategoryModel = categoryDTO2CategoryModel;
        this.orderService = orderService;
        this.categoryService = categoryService;
    }

    @Override
    public OrderProductModel convert(OrderProductDTO orderProductDTO) {
        if (Objects.nonNull(orderProductDTO)) {
            final OrderProductModel orderProduct = new OrderProductModel();
            orderProduct.setCode(orderProductDTO.getCode());
            orderProduct.setId(orderProductDTO.getId());
            orderProduct.setTotal(orderProductDTO.getTotal());
            orderProduct.setQuantity(orderProductDTO.getQuantity());
            if (Objects.nonNull(orderProductDTO.getCategoryDTO())) {
                orderProduct.setCategory(getCategoryDTO2CategoryModel().convert(orderProductDTO.getCategoryDTO()));
            }
            return orderProduct;
        }
        return null;
    }

    public CategoryDTO2CategoryModelConverter getCategoryDTO2CategoryModel() {
        return categoryDTO2CategoryModel;
    }
}

