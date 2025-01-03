package com.example.LR4_Logger.controllers.bookControllers;

import com.example.LR4_Logger.controllers.base.BaseRestController;
import com.example.LR4_Logger.dto.BookDto;
import com.example.LR4_Logger.entities.Book;
import com.example.LR4_Logger.services.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/books")
public class BookRestController extends BaseRestController<Book, BookDto, Long> {
    public BookRestController(BookService bookService) {
        super(bookService);
    }
}
