package com.spring.core.repository;

import com.spring.core.model.AItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface ITypeManagementJpaRepository<T extends AItemModel> extends JpaRepository<T, Long> {

    @Query("SELECT item FROM #{#entityName} item WHERE item.code = :code")
    T findByCode(@Param("code") String var1);
}
