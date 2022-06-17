package com.spring.modules.product.facades.impls;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.core.facades.impls.ATypeManagementFacade;
import com.spring.core.response.EResponse;
import com.spring.modules.product.controllers.dto.LaptopDTO;
import com.spring.modules.product.models.LaptopModel;
import com.spring.modules.product.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class LaptopFacade extends ATypeManagementFacade<LaptopDTO, LaptopModel, LaptopService> {

    @Autowired
    public LaptopFacade(final LaptopService service,
                        final ADTO2ModelConverter<LaptopDTO, LaptopModel> dto2model,
                        final AModel2DTOConverter<LaptopModel, LaptopDTO> model2dto) {
        super(service, dto2model, model2dto);
    }

    public List<LaptopDTO> getByCountAndType(int count, String type, Model model) {
        List<LaptopModel> laptops = getService().getAll();
        if(type.equals("desc")) {
            Collections.sort(laptops, new Comparator<LaptopModel>() {
                @Override
                public int compare(LaptopModel p1, LaptopModel p2) {
                    return Long.compare(p2.getPrice(), p1.getPrice());
                }
            });
        } else {
            Collections.sort(laptops, new Comparator<LaptopModel>() {
                @Override
                public int compare(LaptopModel p1, LaptopModel p2) {
                    return Long.compare(p1.getPrice(), p2.getPrice());
                }
            });
        }

        laptops = laptops.subList(0, count);

        if(laptops.size() > EResponse.COUNT_PRODUCT_LOAD) {
            model.addAttribute("loadmore", true);
            return getModel2dto().convertAll(laptops.subList(0, EResponse.COUNT_PRODUCT_LOAD));
        } else {
            return getModel2dto().convertAll(laptops);
        }
    }
}
