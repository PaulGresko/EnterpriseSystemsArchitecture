package com.example.LR2_Spring.services;

import com.example.LR2_Spring.entities.Library;
import com.example.LR2_Spring.repositories.LibraryRepository;
import com.example.LR2_Spring.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService implements BaseService<Library, Long> {

    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public Library findById(Long id) {
        return libraryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No library found with id: " + id)
        );
    }

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public void save(Library entity) {
        libraryRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        libraryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No library found with id: " + id)
        );
        libraryRepository.deleteById(id);
    }

    @Override
    public void update(Library entity) {
        libraryRepository.findById(entity.getId()).orElseThrow(
                () -> new RuntimeException("No library found with id: " + entity.getId())
        );
        libraryRepository.save(entity);
    }
}
