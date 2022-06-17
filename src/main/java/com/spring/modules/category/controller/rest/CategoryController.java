package com.spring.modules.category.controller.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.modules.category.controller.dtos.CategoryDTO;
import com.spring.modules.category.facades.imps.CategoryFacade;
import com.spring.modules.category.model.CategoryModel;
import com.spring.modules.category.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController extends ATypeManagementRestController<CategoryDTO, CategoryModel, CategoryService, CategoryFacade> {

    protected CategoryController(final CategoryFacade facade) {
        super(facade);
    }

    @GetMapping("/get-by-cmid")
    public List<CategoryDTO> getByCmID(@RequestParam int cmID) {
        try {
            return getFacade().getByCmID(cmID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
