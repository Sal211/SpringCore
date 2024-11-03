package com.example.BookManagement.services;

import com.example.BookManagement.entities.Book;
import com.example.BookManagement.exceptions.BusinessException;
import com.example.BookManagement.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService implements BaseService<Book> {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book entity) {
        return bookRepository.save(entity);
    }

    @Override
    @Cacheable(value = "books", key = "#id")
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    @CachePut(value = "books",key="#book.id")
    public Book update(Long id, Book entity) {
        return bookRepository.findById(id)
                .map(book ->{
                    book.setTitle(entity.getTitle());
                    book.setCategory(entity.getCategory());
                    book.setAuthor(entity.getAuthor());
                    book.setPublishedYear(entity.getPublishedYear());
                    book.setPrice(entity.getPrice());
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new BusinessException("404","Book not found"));
    }

    @Override
    @CacheEvict(value = "books",key="#id")
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> filterBooks(BookOperation bookOperation){
        return  bookRepository.findAll()
                .stream()
                .filter(bookOperation::operate)
                .collect(Collectors.toList());
    }

    public List<Book> findByAuthor(String author){
        return filterBooks(book -> book.getAuthor().equalsIgnoreCase(author));
    }

    public List<Book> sortBooksByPrice() {
        return bookRepository.findAll()
                .stream()
                .sorted((b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()))
                .collect(Collectors.toList());
    }
}
