package com.example.LR4_Logger.services;

import com.example.LR4_Logger.audit.service.AuditService;
import com.example.LR4_Logger.dto.LibraryDto;
import com.example.LR4_Logger.entities.Library;
import com.example.LR4_Logger.mappers.LibraryMapper;
import com.example.LR4_Logger.repositories.LibraryRepository;
import com.example.LR4_Logger.services.base.BaseService;
import com.example.LR4_Logger.services.base.XmlConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService implements BaseService<Library, LibraryDto, Long>, XmlConvertService {

    private final LibraryRepository libraryRepository;

    private final AuditService auditService;


    @Autowired
    public LibraryService(LibraryRepository libraryRepository, AuditService auditService) {
        this.libraryRepository = libraryRepository;
        this.auditService = auditService;
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
        Library newLibrary = libraryRepository.save(
                LibraryMapper.toEntity(dto)
        );
        auditService.insertAuditEvent(newLibrary);
    }

    @Override
    public void delete(Long id) {
        Library library = libraryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No library found with id: " + id)
        );
        libraryRepository.deleteById(id);
        auditService.deleteAuditEvent(library);
    }

    @Override
    public void update(Library entity) {
        libraryRepository.findById(entity.getId()).orElseThrow(
                () -> new RuntimeException("No library found with id: " + entity.getId())
        );
        Library updatedLibrary = libraryRepository.save(entity);
        auditService.updateAuditEvent(updatedLibrary);
    }

    @Override
    public String getAsXml() {
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
