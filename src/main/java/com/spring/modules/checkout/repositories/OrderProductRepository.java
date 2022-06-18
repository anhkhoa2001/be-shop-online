package com.spring.modules.checkout.repositories;

import com.spring.core.repository.ITypeManagementJpaRepository;
import com.spring.modules.checkout.models.OrderProductModel;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends ITypeManagementJpaRepository<OrderProductModel> {

}
