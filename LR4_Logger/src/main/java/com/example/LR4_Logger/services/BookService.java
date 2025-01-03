package com.example.LR4_Logger.services;

import com.example.LR4_Logger.audit.service.AuditService;
import com.example.LR4_Logger.dto.BookDto;
import com.example.LR4_Logger.entities.Book;
import com.example.LR4_Logger.mappers.BookMapper;
import com.example.LR4_Logger.repositories.BookRepository;
import com.example.LR4_Logger.services.base.BaseService;
import com.example.LR4_Logger.services.base.XmlConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService implements BaseService<Book, BookDto, Long>, XmlConvertService {

    private final BookRepository bookRepository;

    private final LibraryService libraryService;

    private final AuditService auditService;

    @Autowired
    public BookService(BookRepository bookRepository, LibraryService libraryService, AuditService auditService) {
        this.bookRepository = bookRepository;
        this.libraryService = libraryService;
        this.auditService = auditService;
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
    public void save(BookDto dto) {
        Book book = BookMapper.toEntity(dto);
        book.setLibrary(
            libraryService.findById(dto.getLibraryId())
        );
        Book newBook = bookRepository.save(book);
        auditService.insertAuditEvent(newBook);
    }

    @Override
    public void delete(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No Book found with id: " + id)
        );
        bookRepository.deleteById(id);
        auditService.deleteAuditEvent(book);
    }

    @Override
    public void update(Book entity) {
        bookRepository.findById(entity.getId()).orElseThrow(
                () -> new NoSuchElementException("No Book found with id: " + entity.getId())
        );
        Book updatedBook = bookRepository.save(entity);
        auditService.updateAuditEvent(updatedBook);
    }

    @Override
    public String getAsXml() {
        List<Book> books = findAll();
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<books>");
        for (Book book : books) {
            xmlBuilder.append("<book>")
                    .append("<id>").append(book.getId()).append("</id>")
                    .append("<title>").append(book.getTitle()).append("</title>")
                    .append("<description>").append(book.getDescription()).append("</description>")
                    .append("</book>");
        }
        xmlBuilder.append("</books>");
        return xmlBuilder.toString();
    }
}
