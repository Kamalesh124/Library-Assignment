package com.example.assignment.modal;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {      
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int bookId;

    @NotBlank(message="Title can not be empty")
    private String title;

    @NotBlank(message="Title can not be empty")
    private String author;

    @NotBlank(message="Title can not be empty")
    private String Genre;

    @NotNull(message="Status should be specified")
    private boolean status;
    
}
