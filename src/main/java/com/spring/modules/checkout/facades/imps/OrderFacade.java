package com.spring.modules.checkout.facades.imps;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.core.facades.impls.ATypeManagementFacade;
import com.spring.modules.checkout.controllers.dtos.OrderDTO;
import com.spring.modules.checkout.models.OrderModel;
import com.spring.modules.checkout.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        try {
            return getModel2dto().convertAll(getService().getOrderLimit(count));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public void updateStatusById(final long id) {
        try {
            OrderModel order = getService().getById(id);
            order.setStatus(true);
            getService().update(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<OrderDTO> getAllOrdersByCreated(String timer) {
        try {
            return getModel2dto().convertAll(getService().getAllOrdersByCreated(timer));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
