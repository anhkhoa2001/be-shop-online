package com.spring.modules.category.repository;

import com.spring.core.repository.ITypeManagementJpaRepository;
import com.spring.modules.category.model.ProductLineModel;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLineRepository extends ITypeManagementJpaRepository<ProductLineModel> {
}
