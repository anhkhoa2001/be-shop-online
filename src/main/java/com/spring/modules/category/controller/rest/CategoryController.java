package com.spring.modules.category.controller.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.modules.category.controller.dtos.CategoryDTO;
import com.spring.modules.category.facades.imps.CategoryFacade;
import com.spring.modules.category.model.CategoryModel;
import com.spring.modules.category.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController extends ATypeManagementRestController<CategoryDTO, CategoryModel, CategoryService, CategoryFacade> {

    protected CategoryController(final CategoryFacade facade) {
        super(facade);
    }
}
