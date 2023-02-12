package com.example.demo.service;

import com.example.demo.exception.*;
import com.example.demo.model.Book;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.awt.print.*;
import java.util.*;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

    public List<Book> getAllBook(){
        return repository.getBook();
    }

    public Book getById(int id){
        try{
            return repository.findById(id);
        }
        catch(NoSuchElementFoundException exception){
            throw new NoSuchElementFoundException(exception.getMessage());
        }
    }

    public List<BookDao> getByGenre(String genre){
        try{
            return repository.getByGenre(genre);
        }
        catch(NoSuchElementFoundException exception){
            throw new NoSuchElementFoundException(exception.getMessage());
        }
    }

    public List<BookDao> getByPrice(String price){
        try{
            return repository.getByPrice(price);
        }
        catch(NoSuchElementFoundException exception){
            throw new NoSuchElementFoundException(exception.getMessage());
        }
    }

    public Book getByTitle(String title){
        try {
            return repository.findByName(title);
        }catch(NoSuchElementFoundException e){
            throw new NoSuchElementFoundException(e.getMessage());
        }
    }

    public Book getByCode(String codeISBN){
        try{
            return repository.findByCode(codeISBN);
        }catch(NoSuchElementFoundException e){
            throw new NoSuchElementFoundException(e.getMessage());
        }
    }

    public int addBook(Book book){
        return repository.addBook(book);
    }

    public Book updateBook(int id, Book book){
        return repository.updateBook(id,book);
    }

    public int deleteBook(int id){
        try{
            return repository.deleteBook(id);
        }catch (DatabaseErrorException exception){
            throw new BookstoreException(exception.getMessage());
        }
    }
}