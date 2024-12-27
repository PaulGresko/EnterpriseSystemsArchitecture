package com.example.library.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "book")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

}
