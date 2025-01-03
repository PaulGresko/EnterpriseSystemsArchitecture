package com.example.LR3_Rest.mappers;

import com.example.LR3_Rest.dto.BookDto;
import com.example.LR3_Rest.entities.Book;
import com.example.LR3_Rest.entities.Library;

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
