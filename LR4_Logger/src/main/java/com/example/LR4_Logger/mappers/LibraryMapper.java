package com.example.LR4_Logger.mappers;


import com.example.LR4_Logger.dto.LibraryDto;
import com.example.LR4_Logger.entities.Library;

public class LibraryMapper {
    public static Library toEntity(LibraryDto dto) {
        Library library = new Library();
        library.setName(dto.getName());
        library.setAddress(dto.getAddress());
        return library;
    }
}
