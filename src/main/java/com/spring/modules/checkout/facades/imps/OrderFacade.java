package com.spring.modules.checkout.facades.imps;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.core.facades.impls.ATypeManagementFacade;
import com.spring.modules.checkout.controllers.dtos.OrderDTO;
import com.spring.modules.checkout.models.OrderModel;
import com.spring.modules.checkout.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class OrderFacade extends ATypeManagementFacade<OrderDTO, OrderModel, OrderService> {

    @Autowired
    public OrderFacade(final OrderService service,
                        final ADTO2ModelConverter<OrderDTO, OrderModel> dto2model,
                        final AModel2DTOConverter<OrderModel, OrderDTO> model2dto) {
        super(service, dto2model, model2dto);
    }

    public List<OrderDTO> getOrderLimit(final int count) {
        List<OrderDTO> orderDTOS = getAll();
        Collections.sort(orderDTOS, new Comparator<OrderDTO>() {
            @Override
            public int compare(OrderDTO p1, OrderDTO p2) {
                return Integer.compare(p2.getTotal(), p1.getTotal());
            }
        });

        return orderDTOS.size() <= count ? orderDTOS : orderDTOS.subList(0, count);
    }
}
