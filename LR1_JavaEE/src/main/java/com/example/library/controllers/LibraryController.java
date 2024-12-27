package com.example.library.controllers;

import com.example.library.entities.Library;
import com.example.library.services.LibraryService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/libraries")
public class LibraryController extends HttpServlet {

    @EJB
    private LibraryService libraryService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("libraries", libraryService.getAllLibraries());
            request.getRequestDispatcher("library.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String address = request.getParameter("address");

            Library library = new Library();
            library.setName(name);
            library.setAddress(address);

            libraryService.createLibrary(library);

        } else if ("delete".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            libraryService.deleteLibrary(id);

        }

        doGet(request, response);
    }
}
