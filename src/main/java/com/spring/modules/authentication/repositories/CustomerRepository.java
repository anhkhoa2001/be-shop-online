package com.spring.modules.authentication.repositories;

import com.spring.core.repository.ITypeManagementJpaRepository;
import com.spring.modules.authentication.models.CustomerModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository extends ITypeManagementJpaRepository<CustomerModel> {

    CustomerModel findCustomerModelByUsername(final String username);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CustomerModel c WHERE c.username = :username")
    void deleteByUsername(@Param("username") final String username);
}
