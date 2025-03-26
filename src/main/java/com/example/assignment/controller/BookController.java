package com.example.assignment.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.Exception.BookConflictException;
import com.example.assignment.Exception.BookNotFoundException;
import com.example.assignment.modal.Book;
import com.example.assignment.service.BookService;

@RestController
public class BookController {
    
    @Autowired
    BookService service;

    @GetMapping("/")
    public ResponseEntity<String> welcomeMessage() {
    String welcomeText = "Welcome to the Library Management System!\n" +
        "Available Endpoints:\n" +
        "- GET /books : Retrieve all books\n" +
        "- GET /book/id/{bookId} : Get book by ID\n" +
        "- GET /book/title/{title} : Search books by title\n" +
        "- POST /book/add : Add a new book\n" +
        "- PUT /book/update/{bookId} : Update an existing book\n" +
        "- DELETE /book/delete/{bookId} : Delete a book\n" +
        "\nDeployed at: https://library-assignment-production.up.railway.app/";
    return new ResponseEntity<>(welcomeText, HttpStatus.OK);
   }
   
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(service.getAllBooks(),HttpStatus.OK);
    }

    @GetMapping("/book/id/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable int bookId){
        try{
             Book book=service.getBookById(bookId);
             return new ResponseEntity<>(book,HttpStatus.OK);
        }
        catch(BookNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/title/{title}")
    public ResponseEntity<?> getBookByTitle(@PathVariable String title) {
    try {
        List<Book> books = service.getBookByTitle(title); 
        return new ResponseEntity<>(books, HttpStatus.OK);  
    } catch (BookNotFoundException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
     }
  }

    @PostMapping("/book/add")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        try{
             service.addBook(book);
             return new ResponseEntity<>("Adding new book..",HttpStatus.OK);
        }
        catch(BookConflictException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/book/update/{bookId}")
    public ResponseEntity<String> updateBook(@RequestBody Book book,@PathVariable int bookId){
        try{
             book.setBookId(bookId);
             service.updateBook(book);
             return new ResponseEntity<>(" book updated..",HttpStatus.OK);
        }
        catch(BookNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/book/delete/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable int bookId){
        try{
            service.deleteBook(bookId);
            return new ResponseEntity<>("Book is deleted",HttpStatus.OK);
        }
        catch(BookNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/exit")
    public ResponseEntity<String> exitApplication() {
        SpringApplication.exit(context, () -> 0);
        return new ResponseEntity<>("Application is shutting down...", HttpStatus.OK);
    }
}
