package com.spring.modules.category.controller.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.modules.category.controller.dtos.CategoryDTO;
import com.spring.modules.category.facades.imps.CategoryFacade;
import com.spring.modules.category.model.CategoryModel;
import com.spring.modules.category.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryRestController extends ATypeManagementRestController<CategoryDTO, CategoryModel, CategoryService, CategoryFacade> {

    protected CategoryRestController(final CategoryFacade facade) {
        super(facade);
    }

    @GetMapping("/get-by-cmid")
    public ResponseEntity<List<CategoryDTO>> getByCmID(@RequestParam int cmID) {
        try {
            return new ResponseEntity<>(getFacade().getByCmID(cmID), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
