package com.spring.modules.category.service;

import com.spring.core.repository.ITypeManagementJpaRepository;
import com.spring.core.service.ATypeManagementService;
import com.spring.modules.category.model.CategoryModel;
import com.spring.modules.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends ATypeManagementService<CategoryModel> {

    @Autowired
    public CategoryService(final CategoryRepository categoryRepository) {
        super(categoryRepository);
    }
}
