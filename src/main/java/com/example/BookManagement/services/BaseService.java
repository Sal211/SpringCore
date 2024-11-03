package com.example.BookManagement.services;

import com.example.BookManagement.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BaseService<T> {
    T save(T entity);
    Optional<T> findById(Long id);
    List<T> findAll();
    T update(Long id,T entity);
    void delete(Long id);
}

@FunctionalInterface
interface BookOperation {
    boolean operate(Book book);
}