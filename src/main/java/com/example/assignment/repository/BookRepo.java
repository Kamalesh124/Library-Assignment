package com.example.assignment.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment.modal.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer>{
   List<Book> findByTitle(String title);
}
