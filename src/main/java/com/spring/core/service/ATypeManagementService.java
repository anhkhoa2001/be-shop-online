package com.spring.core.service;

import com.spring.core.model.AItemModel;
import com.spring.core.repository.ITypeManagementJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class ATypeManagementService<T extends AItemModel> {

    private final ITypeManagementJpaRepository<T> r;

    public ATypeManagementService(final ITypeManagementJpaRepository<T> r) {
        this.r = r;
    }

    public List<T> getAll() {
        return getR().findAll();
    }

    public T findByCode(String code) {
        return getR().findByCode(code);
    }

    public T getById(long id) {
        return getR().findById(id).get();
    }

    public void create(T t) {
        getR().save(t);
    }

    public void update(T t) {
        getR().save(t);
    }

    public void deleteById(long id) {
        getR().deleteById(id);
    }

    public ITypeManagementJpaRepository<T> getR() {
        return r;
    }
}
