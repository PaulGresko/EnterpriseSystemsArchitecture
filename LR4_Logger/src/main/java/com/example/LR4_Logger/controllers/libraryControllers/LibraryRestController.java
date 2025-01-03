package com.example.LR4_Logger.controllers.libraryControllers;

import com.example.LR4_Logger.controllers.base.BaseRestController;
import com.example.LR4_Logger.dto.LibraryDto;
import com.example.LR4_Logger.entities.Library;
import com.example.LR4_Logger.services.LibraryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/libraries")
public class LibraryRestController extends BaseRestController<Library, LibraryDto, Long> {

    public LibraryRestController(LibraryService libraryService) {
        super(libraryService);
    }
}
