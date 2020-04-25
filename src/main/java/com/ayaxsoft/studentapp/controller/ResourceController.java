package com.ayaxsoft.studentapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public abstract class ResourceController <T> {

    @GetMapping
    abstract ResponseEntity<List<T>> index();

    @PostMapping
    abstract ResponseEntity<T> save(@RequestBody T entity);

    @PutMapping
    abstract ResponseEntity<T> update(@RequestBody T entity);

    @GetMapping("/{id}")
    abstract ResponseEntity<T> details(@PathVariable(name = "id") int id);

    @DeleteMapping("/{id}")
    abstract ResponseEntity<String> delete(@PathVariable(name = "id") int id);
}
