package com.example.LR4_Logger.entities;

import com.example.LR4_Logger.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

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
    @ToString.Exclude
    private Library library;

}
