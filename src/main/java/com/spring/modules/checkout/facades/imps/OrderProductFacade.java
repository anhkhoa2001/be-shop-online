package com.spring.modules.checkout.facades.imps;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.core.facades.impls.ATypeManagementFacade;
import com.spring.modules.checkout.controllers.dtos.OrderProductDTO;
import com.spring.modules.checkout.models.OrderProductModel;
import com.spring.modules.checkout.services.OrderProductService;
import com.spring.modules.product.controllers.dto.LaptopDTO;
import com.spring.modules.product.controllers.dto.PhoneTabDTO;
import com.spring.modules.product.facades.impls.LaptopFacade;
import com.spring.modules.product.facades.impls.PhoneTabFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class OrderProductFacade extends ATypeManagementFacade<OrderProductDTO, OrderProductModel, OrderProductService> {

    @Autowired
    public OrderProductFacade(final OrderProductService service,
                       final ADTO2ModelConverter<OrderProductDTO, OrderProductModel> dto2model,
                       final AModel2DTOConverter<OrderProductModel, OrderProductDTO> model2dto) {
        super(service, dto2model, model2dto);
    }

    public Map<String, Integer> getOrderProductLimit(final int count) {
        List<OrderProductDTO> orderProductDTOS = getAll();

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<orderProductDTOS.size(); i++) {
            if(map.size() > 0) {
                String code = orderProductDTOS.get(i).getCode();
                int val = 0;
                for (String entry : map.keySet()) {
                    if(entry.equals(code)) {
                        int value = map.get(entry) + orderProductDTOS.get(i).getQuantity();
                        map.put(entry, value);
                        val++;
                    }
                }
                if(val == 0) {
                    map.put(orderProductDTOS.get(i).getCode(), orderProductDTOS.get(i).getQuantity());
                }
            } else {
                map.put(orderProductDTOS.get(i).getCode(), orderProductDTOS.get(i).getQuantity());
            }
        }
        return map;
    }

    public String convertCodeToString(String code, LaptopFacade laptopFacade, PhoneTabFacade phoneTabFacade) {
        String nameString = null;
        String image = null;
        List<PhoneTabDTO> phoneTabDTOS = phoneTabFacade.getAll();
        List<LaptopDTO> laptopDTOS = laptopFacade.getAll();

        for(PhoneTabDTO o:phoneTabDTOS) {
            if(o.getCode().equals(code)) {
                nameString = o.getName();
                image = o.getImage();
            }
        }

        for(LaptopDTO o:laptopDTOS) {
            if(o.getCode().equals(code)) {
                nameString = o.getName();
                image = o.getImage();
            }
        }

        return code + "|||" + nameString + "|||" + image;
    }


    public List<OrderProductDTO> getByOrderID(final int oid) {
        try {
            return getModel2dto().convertAll(getService().getByOrderID(oid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}

