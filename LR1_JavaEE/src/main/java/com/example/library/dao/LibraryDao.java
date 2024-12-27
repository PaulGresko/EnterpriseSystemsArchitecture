package com.example.library.dao;


import com.example.library.entities.Library;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;


@Stateless
public class LibraryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Library library) {
        entityManager.persist(library);
    }

    public Library findById(Long id) {
        return entityManager.find(Library.class, id);
    }

    public List<Library> findAll() {
        return entityManager.createQuery("SELECT l FROM Library l", Library.class).getResultList();
    }

    public Library update(Library library) {
        return entityManager.merge(library);
    }

    public void delete(Long id) {
        Library library = entityManager.find(Library.class, id);
        if (library != null) {
            entityManager.remove(library);
        }
    }
}
