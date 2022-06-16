package com.spring.modules.category.repository;

import com.spring.core.repository.ITypeManagementJpaRepository;
import com.spring.modules.category.model.ManufacturerModel;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends ITypeManagementJpaRepository<ManufacturerModel> {

}
