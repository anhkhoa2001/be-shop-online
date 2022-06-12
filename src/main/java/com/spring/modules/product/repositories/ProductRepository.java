package com.spring.modules.product.repositories;

import com.spring.contants.repository.ITypeManagementJpaRepository;
import com.spring.modules.product.models.ProductModel;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ITypeManagementJpaRepository<ProductModel> {

}
