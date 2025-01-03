package com.example.LR2_Spring.controllers;

import com.example.LR2_Spring.entities.Library;
import com.example.LR2_Spring.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/libraries")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public String listLibraries(Model model) {
        model.addAttribute("libraries", libraryService.findAll());
        return "libraries";
    }

    @PostMapping
    public String saveLibrary(@ModelAttribute Library library) {
        libraryService.save(library);
        return "redirect:/libraries";
    }
}
