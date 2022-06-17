package com.spring.modules.authentication.services;

import com.spring.core.service.ATypeManagementService;
import com.spring.modules.authentication.models.CustomerModel;
import com.spring.modules.authentication.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends ATypeManagementService<CustomerModel> {

    @Autowired
    public CustomerService(final CustomerRepository customerRepository) {
        super(customerRepository);
    }

    public CustomerModel findByUsername(final String username) {
        CustomerRepository repository = (CustomerRepository) getR();
        return repository.findCustomerModelByUsername(username);
    }
}
