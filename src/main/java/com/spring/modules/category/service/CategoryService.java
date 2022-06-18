package com.spring.modules.category.service;

import com.spring.core.service.ATypeManagementService;
import com.spring.modules.category.model.CategoryModel;
import com.spring.modules.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService extends ATypeManagementService<CategoryModel> {

    @Autowired
    public CategoryService(final CategoryRepository categoryRepository) {
        super(categoryRepository);
    }

    public List<CategoryModel> getByCmID(final int cmID) {
        if(cmID == 0) {
            return getAll();
        } else {
            List<CategoryModel> categories = new ArrayList<>();

            getAll().forEach(e -> {
                if(e.getProductLine().getId() == cmID) {
                    categories.add(e);
                }
            });
            return categories;
        }
    }
}
