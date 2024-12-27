package com.example.library.services;

import com.example.library.entities.Book;
import com.example.library.dao.BookDao;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class BookService {

    @EJB
    private BookDao bookDao;

    public List<Book> getAllBooks() {
        List<Book> books = bookDao.findAll();
        System.out.println("books: "  + books);
        return books;
    }

    public void createBook(Book newTeam) {
        bookDao.save(newTeam);
    }

    public void deleteBook(Long id) {
        bookDao.delete(id);
    }

    public void updateBook(Book newTeam) {
        bookDao.update(newTeam);
    }
}
