package com.ayaxsoft.studentapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class ResourceController <T> {

    abstract ResponseEntity<List<T>> index();
    abstract ResponseEntity<T> save(T entity);
    abstract ResponseEntity<T> update(T entity);
    abstract ResponseEntity<T> details(int id);
    abstract ResponseEntity<String> delete(int id);
}
