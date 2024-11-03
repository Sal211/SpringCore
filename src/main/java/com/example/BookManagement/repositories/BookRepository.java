package com.example.BookManagement.repositories;

import com.example.BookManagement.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
