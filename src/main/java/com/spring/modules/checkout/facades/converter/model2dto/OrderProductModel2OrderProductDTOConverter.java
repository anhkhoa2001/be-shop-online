package com.spring.modules.checkout.facades.converter.model2dto;

import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.modules.category.facades.converters.model2dto.CategoryModel2CategoryDTOConverter;
import com.spring.modules.checkout.controllers.dtos.OrderProductDTO;
import com.spring.modules.checkout.models.OrderProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OrderProductModel2OrderProductDTOConverter extends AModel2DTOConverter<OrderProductModel, OrderProductDTO> {

    private final CategoryModel2CategoryDTOConverter categoryModel2CategoryDTO;

    @Autowired
    public OrderProductModel2OrderProductDTOConverter(final CategoryModel2CategoryDTOConverter categoryModel2CategoryDTO) {
        super(new OrderProductDTO());
        this.categoryModel2CategoryDTO = categoryModel2CategoryDTO;
    }

    @Override
    public OrderProductDTO convert(OrderProductModel orderProduct) {
        if (Objects.nonNull(orderProduct)) {
            final OrderProductDTO orderProductDTO = new OrderProductDTO();
            orderProductDTO.setCode(orderProduct.getCode());
            orderProductDTO.setId(orderProduct.getId());
            orderProductDTO.setTotal(orderProduct.getTotal());
            orderProductDTO.setQuantity(orderProduct.getQuantity());

            if (Objects.nonNull(orderProduct.getCategory())) {
                orderProductDTO.setCategoryDTO(getCategoryModel2CategoryDTO().convert(orderProduct.getCategory()));
            }
            return orderProductDTO;
        }
        return null;
    }

    public CategoryModel2CategoryDTOConverter getCategoryModel2CategoryDTO() {
        return categoryModel2CategoryDTO;
    }
}