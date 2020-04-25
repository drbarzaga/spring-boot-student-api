package com.ayaxsoft.studentapp.service;

import java.util.List;

public abstract class BaseService<T> {
    public abstract List<T> getAll();
    public abstract T save(T entity);
    public abstract T update(T entity);
    public abstract T getById(int id);
    public abstract void delete(int id);
}
