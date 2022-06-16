package com.spring.modules.category.facades.imps;

import com.spring.core.facedes.converter.dto2model.ADTO2ModelConverter;
import com.spring.core.facedes.converter.model2dto.AModel2DTOConverter;
import com.spring.core.facedes.impls.ATypeManagementFacade;
import com.spring.modules.category.controller.dtos.CategoryDTO;
import com.spring.modules.category.model.CategoryModel;
import com.spring.modules.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryFacade extends ATypeManagementFacade<CategoryDTO, CategoryModel, CategoryService> {

    @Autowired
    public CategoryFacade(final CategoryService service,
                         final ADTO2ModelConverter<CategoryDTO, CategoryModel> dto2model,
                         final AModel2DTOConverter<CategoryModel, CategoryDTO> model2dto) {
        super(service, dto2model, model2dto);
    }
}
