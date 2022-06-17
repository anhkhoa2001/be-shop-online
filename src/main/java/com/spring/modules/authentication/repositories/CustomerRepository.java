package com.spring.modules.authentication.repositories;

import com.spring.core.repository.ITypeManagementJpaRepository;
import com.spring.modules.authentication.models.CustomerModel;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ITypeManagementJpaRepository<CustomerModel> {

    CustomerModel findCustomerModelByUsername(final String username);
}
