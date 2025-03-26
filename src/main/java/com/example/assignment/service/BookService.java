package com.example.assignment.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.Exception.BookConflictException;
import com.example.assignment.Exception.BookNotFoundException;
import com.example.assignment.modal.Book;
import com.example.assignment.repository.BookRepo;

@Service
public class BookService {
     
    @Autowired
    BookRepo repo;

    public List<Book> getAllBooks(){
         return repo.findAll();
    }

    public Book getBookById(int bookId){  
        return repo.findById(bookId).orElseThrow(()->new BookNotFoundException("No book found with ID : "+bookId));
    }

    public List<Book> getBookByTitle(String title) {
        List<Book> books = repo.findByTitle(title);
        if (books.isEmpty()) {
            throw new BookNotFoundException("No book found with title: " + title);
        }
        return books;  
    }
    

    public void addBook(Book book){
        if(repo.existsById(book.getBookId())){
            throw new BookConflictException("The book already exist with ID: "+book.getBookId());
        }
        repo.save(book);
    }

    public void updateBook(Book book) {
        if (!repo.existsById(book.getBookId())) {
            throw new BookNotFoundException("Book does not exist with ID: " + book.getBookId());
        }
        repo.save(book);
    }
    

    public void deleteBook(int bookId){
        if(!repo.existsById(bookId)){
            throw new BookNotFoundException("Book does not exist with ID: "+bookId);
        }
        repo.deleteById(bookId);
    }
}
