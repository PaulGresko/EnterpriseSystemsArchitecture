package com.example.LR2_Spring.entities;

import com.example.LR2_Spring.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "book")
@Entity
public class Book implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

}
