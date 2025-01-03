package com.example.LR4_Logger.mappers;

import com.example.LR4_Logger.dto.BookDto;
import com.example.LR4_Logger.entities.Book;
import com.example.LR4_Logger.entities.Library;

public class BookMapper {
    public static Book toEntity(BookDto dto) {
        Book book = new Book();
        Library library = new Library();
        library.setId(dto.getLibraryId());
        book.setLibrary(library);
        book.setTitle(dto.getTitle());
        book.setDescription(dto.getDescription());
        return book;
    }
}
