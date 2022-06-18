package com.spring.modules.checkout.repositories;

import com.spring.core.repository.ITypeManagementJpaRepository;
import com.spring.modules.checkout.models.OrderModel;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends ITypeManagementJpaRepository<OrderModel> {

}
