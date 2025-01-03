package com.example.LR3_Rest.controllers.bookControllers;

import com.example.LR3_Rest.controllers.base.BaseRestController;
import com.example.LR3_Rest.dto.BookDto;
import com.example.LR3_Rest.entities.Book;
import com.example.LR3_Rest.services.BookService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/books")
public class BookRestController extends BaseRestController<Book, BookDto, Long> {
    public BookRestController(BookService bookService) {
        super(bookService);
    }
}
