package com.example.LR3_Rest.entities;

import com.example.LR3_Rest.entities.base.BaseEntity;
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
