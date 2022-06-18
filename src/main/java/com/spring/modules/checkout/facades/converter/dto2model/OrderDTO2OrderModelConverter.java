package com.spring.modules.checkout.facades.converter.dto2model;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.modules.checkout.controllers.dtos.OrderDTO;
import com.spring.modules.checkout.models.OrderModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Objects;

@Component
public class OrderDTO2OrderModelConverter extends ADTO2ModelConverter<OrderDTO, OrderModel> {

    private final OrderProductDTO2OrderProductModelConverter orderProductDTO2OrderProductModel;

    @Autowired
    public OrderDTO2OrderModelConverter(final OrderProductDTO2OrderProductModelConverter orderProductDTO2OrderProductModel) {
        super(new OrderModel());
        this.orderProductDTO2OrderProductModel = orderProductDTO2OrderProductModel;
    }

    @Override
    public OrderModel convert(OrderDTO orderDTO) {
        if(Objects.nonNull(orderDTO)) {
            final OrderModel order = new OrderModel();
            order.setCode(orderDTO.getCode());
            order.setId(orderDTO.getId());
            order.setTotal(orderDTO.getTotal());
            order.setQuantity(orderDTO.getQuantity());
            order.setStatus(orderDTO.isStatus());

            if(!CollectionUtils.isEmpty(orderDTO.getOrderProductDTOs())) {
                order.setOrderProducts(getOrderProductDTO2OrderProductModel().convertList2Set(orderDTO.getOrderProductDTOs()));
            }
            if(!StringUtils.isBlank(orderDTO.getName())) {
                order.setName(orderDTO.getName());
            }
            if(!StringUtils.isBlank(orderDTO.getPhone())) {
                order.setPhone(orderDTO.getPhone());
            }
            if(!StringUtils.isBlank(orderDTO.getAddress())) {
                order.setAddress(orderDTO.getAddress());
            }
            if(!StringUtils.isBlank(orderDTO.getCreated())) {
                order.setCreated(orderDTO.getCreated());
            }
            if(!StringUtils.isBlank(orderDTO.getEmail())) {
                order.setEmail(orderDTO.getEmail());
            }

            return order;
        }
        return null;
    }

    public OrderProductDTO2OrderProductModelConverter getOrderProductDTO2OrderProductModel() {
        return orderProductDTO2OrderProductModel;
    }
}