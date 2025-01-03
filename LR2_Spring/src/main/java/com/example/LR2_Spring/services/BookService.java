package com.example.LR2_Spring.services;

import com.example.LR2_Spring.entities.Book;
import com.example.LR2_Spring.repositories.BookRepository;
import com.example.LR2_Spring.services.base.BaseService;
import org.hibernate.internal.build.AllowNonPortable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService implements BaseService<Book, Long> {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No Book found with id: " + id)
        );
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book entity) {
        bookRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        bookRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No Book found with id: " + id)
        );
        bookRepository.deleteById(id);
    }

    @Override
    public void update(Book entity) {
        bookRepository.findById(entity.getId()).orElseThrow(
                () -> new NoSuchElementException("No Book found with id: " + entity.getId())
        );
        bookRepository.save(entity);
    }
}
