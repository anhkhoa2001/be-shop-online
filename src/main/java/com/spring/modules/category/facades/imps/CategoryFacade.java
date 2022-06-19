package com.spring.modules.category.facades.imps;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.core.facades.impls.ATypeManagementFacade;
import com.spring.modules.category.controller.dtos.CategoryDTO;
import com.spring.modules.category.model.CategoryModel;
import com.spring.modules.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryFacade extends ATypeManagementFacade<CategoryDTO, CategoryModel, CategoryService> {

    @Autowired
    public CategoryFacade(final CategoryService service,
                         final ADTO2ModelConverter<CategoryDTO, CategoryModel> dto2model,
                         final AModel2DTOConverter<CategoryModel, CategoryDTO> model2dto) {
        super(service, dto2model, model2dto);
    }

    public List<CategoryDTO> getByCmID(final int cmID) {
        try {
            if(CollectionUtils.isEmpty(getService().getByCmID(cmID))) {
                return Collections.emptyList();
            } else {
                return getModel2dto().convertAll(getService().getByCmID(cmID));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    //constain
    public CategoryDTO findByCategoryCode(final String categoryCode) {
        try {
            return getModel2dto().convert(getService().findByCategoryCode(categoryCode));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
