package com.spring.contants.service;

import com.spring.contants.model.AItemModel;
import com.spring.contants.repository.ITypeManagementJpaRepository;

import java.util.List;

public abstract class ITypeManagementService<T extends AItemModel, R extends ITypeManagementJpaRepository<T>> {

    private final R r;

    public ITypeManagementService(final R r) {
        this.r = r;
    }

    public List<T> getAll() {
        return getR().findAll();
    }

    public T getById(long id) {
        return getR().findById(id).get();
    }

    public boolean create(T t) {
        int before = getAll().size();
        getR().save(t);
        int last = getAll().size();
        return before < last;
    }

    public void update(T t) {
        getR().save(t);
    }

    public boolean deleteById(long id) {
        int before = getAll().size();
        getR().deleteById(id);
        int last = getAll().size();
        return before > last;
    }

    public R getR() {
        return r;
    }
}
