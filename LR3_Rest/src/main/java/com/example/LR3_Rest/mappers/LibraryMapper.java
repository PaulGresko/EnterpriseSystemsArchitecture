package com.example.LR3_Rest.mappers;


import com.example.LR3_Rest.dto.LibraryDto;
import com.example.LR3_Rest.entities.Library;

public class LibraryMapper {
    public static Library toEntity(LibraryDto dto) {
        Library library = new Library();
        library.setName(dto.getName());
        library.setAddress(dto.getAddress());
        return library;
    }
}
