package com.example.library.controllers;

import com.example.library.entities.Book;
import com.example.library.services.BookService;
import com.example.library.services.LibraryService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/books")
public class BookController extends HttpServlet {

    @EJB
    private BookService bookService;

    @EJB
    private LibraryService libraryService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("books", bookService.getAllBooks());
        request.setAttribute("libraries", libraryService.getAllLibraries());
        request.getRequestDispatcher("book.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            Long libraryId = Long.parseLong(request.getParameter("library_id"));

            Book book = new Book();
            book.setTitle(title);
            book.setDescription(description);
            book.setLibrary(libraryService.getLibraryById(libraryId));

            bookService.createBook(book);

        } else if ("delete".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            bookService.deleteBook(id);

        }

        doGet(request, response);
    }
}
