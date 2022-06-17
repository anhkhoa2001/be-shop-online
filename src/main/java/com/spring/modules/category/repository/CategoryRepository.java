package com.spring.modules.category.repository;

import com.spring.core.repository.ITypeManagementJpaRepository;
import com.spring.modules.category.model.CategoryModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends ITypeManagementJpaRepository<CategoryModel> {

}
