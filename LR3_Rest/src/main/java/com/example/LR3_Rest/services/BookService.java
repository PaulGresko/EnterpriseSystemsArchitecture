package com.example.LR3_Rest.services;

import com.example.LR3_Rest.dto.BookDto;
import com.example.LR3_Rest.entities.Book;
import com.example.LR3_Rest.mappers.BookMapper;
import com.example.LR3_Rest.repositories.BookRepository;
import com.example.LR3_Rest.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService implements BaseService<Book, BookDto, Long> {

    private final BookRepository bookRepository;

    private final LibraryService libraryService;

    @Autowired
    public BookService(BookRepository bookRepository, LibraryService libraryService) {
        this.bookRepository = bookRepository;
        this.libraryService = libraryService;
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
        bookRepository.save(book);
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

    public String getBooksAsXml() {
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
