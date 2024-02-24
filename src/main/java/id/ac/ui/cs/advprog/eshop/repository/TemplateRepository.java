package id.ac.ui.cs.advprog.eshop.repository;

import java.util.Iterator;

public interface TemplateRepository<T> {
    T create(T product);

    T findById(String id);

    T update(T updatedProduct);

    Iterator<T> findAll();

    T deleteById(String id);
}