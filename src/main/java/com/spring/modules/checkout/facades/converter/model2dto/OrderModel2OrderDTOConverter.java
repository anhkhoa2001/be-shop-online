package com.spring.modules.checkout.facades.converter.model2dto;

import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.modules.checkout.controllers.dtos.OrderDTO;
import com.spring.modules.checkout.models.OrderModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Objects;

@Component
public class OrderModel2OrderDTOConverter extends AModel2DTOConverter<OrderModel, OrderDTO> {

    private final OrderProductModel2OrderProductDTOConverter orderProductModel2OrderProductDTO;

    @Autowired
    public OrderModel2OrderDTOConverter(final OrderProductModel2OrderProductDTOConverter orderProductModel2OrderProductDTO) {
        super(new OrderDTO());
        this.orderProductModel2OrderProductDTO = orderProductModel2OrderProductDTO;
    }

    @Override
    public OrderDTO convert(OrderModel order) {
        if(Objects.nonNull(order)) {
            final OrderDTO orderDTO = new OrderDTO();
            orderDTO.setCode(order.getCode());
            orderDTO.setId(order.getId());
            orderDTO.setTotal(order.getTotal());
            orderDTO.setQuantity(order.getQuantity());
            orderDTO.setStatus(order.isStatus());

            if(!CollectionUtils.isEmpty(order.getOrderProducts())) {
                orderDTO.setOrderProductDTOs(getOrderProductModel2OrderProductDTO().convertSet2List(order.getOrderProducts()));
            }
            if(!StringUtils.isBlank(order.getName())) {
                orderDTO.setName(order.getName());
            }
            if(!StringUtils.isBlank(order.getPhone())) {
                orderDTO.setPhone(order.getPhone());
            }
            if(!StringUtils.isBlank(order.getAddress())) {
                orderDTO.setAddress(order.getAddress());
            }
            if(!StringUtils.isBlank(order.getCreated())) {
                orderDTO.setCreated(order.getCreated());
            }
            if(!StringUtils.isBlank(order.getEmail())) {
                orderDTO.setEmail(order.getEmail());
            }

            return orderDTO;
        }
        return null;
    }

    public OrderProductModel2OrderProductDTOConverter getOrderProductModel2OrderProductDTO() {
        return orderProductModel2OrderProductDTO;
    }
}
