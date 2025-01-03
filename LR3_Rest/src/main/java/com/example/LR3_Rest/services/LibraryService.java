package com.example.LR3_Rest.services;

import com.example.LR3_Rest.dto.LibraryDto;
import com.example.LR3_Rest.entities.Library;
import com.example.LR3_Rest.mappers.LibraryMapper;
import com.example.LR3_Rest.repositories.LibraryRepository;
import com.example.LR3_Rest.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService implements BaseService<Library, LibraryDto, Long> {

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
    public void save(LibraryDto dto) {
        libraryRepository.save(
                LibraryMapper.toEntity(dto)
        );
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

    public String getLibrariesAsXml() {
        List<Library> libraries = findAll();
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<libraries>");
        for (Library library : libraries) {
            xmlBuilder.append("<library>")
                    .append("<id>").append(library.getId()).append("</id>")
                    .append("<name>").append(library.getName()).append("</name>")
                    .append("<address>").append(library.getAddress()).append("</address>")
                    .append("</library>");
        }
        xmlBuilder.append("</libraries>");
        return xmlBuilder.toString();
    }
}
