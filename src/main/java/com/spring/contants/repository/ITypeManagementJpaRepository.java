package com.spring.contants.repository;

import com.spring.contants.model.AItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ITypeManagementJpaRepository<T extends AItemModel> extends JpaRepository<T, Long> {
}
