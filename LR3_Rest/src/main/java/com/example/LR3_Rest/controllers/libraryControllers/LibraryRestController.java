package com.example.LR3_Rest.controllers.libraryControllers;

import com.example.LR3_Rest.controllers.base.BaseRestController;
import com.example.LR3_Rest.dto.LibraryDto;
import com.example.LR3_Rest.entities.Library;
import com.example.LR3_Rest.services.LibraryService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/libraries")
public class LibraryRestController extends BaseRestController<Library, LibraryDto, Long> {

    public LibraryRestController(LibraryService libraryService) {
        super(libraryService);
    }
}
