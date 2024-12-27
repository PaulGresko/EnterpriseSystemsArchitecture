package com.example.library.services;

import com.example.library.entities.Library;
import com.example.library.dao.LibraryDao;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class LibraryService {

    @EJB
    private LibraryDao libraryDao;

    public List<Library> getAllLibraries() {
        return libraryDao.findAll();
    }

    public Library getLibraryById(Long id) {
        return libraryDao.findById(id);
    }

    public void createLibrary(Library library) {
        libraryDao.save(library);
    }

    public void deleteLibrary(Long id) {
        libraryDao.delete(id);
    }

    public void updateLibrary(Library library) {
        libraryDao.update(library);
    }

}
