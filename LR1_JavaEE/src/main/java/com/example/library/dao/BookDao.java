package com.example.library.dao;


import com.example.library.entities.Book;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import java.util.List;


@Stateless
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book update(Book book) {
        return entityManager.merge(book);
    }

    public void delete(Long id) {
        Book book = entityManager.find(Book.class, id);
        if (book != null) {
            entityManager.remove(book);
        }
    }

    public List<Book> findAll() {
        List<Book> books =  entityManager
                .createQuery("SELECT b FROM Book b", Book.class)
                .getResultList();
        System.out.println("books: "  + books);
        return books;
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> getBooksByLibraryId(Long libraryId) {
        return entityManager.createQuery("SELECT b FROM Book b WHERE b.library.id = :libraryId", Book.class)
                .setParameter("libraryId", libraryId)
                .getResultList();
    }
}
