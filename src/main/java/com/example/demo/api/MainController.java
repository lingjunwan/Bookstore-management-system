package com.example.demo.api;

import com.example.demo.exception.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(maxAge=45000)
public class MainController {

    @Autowired
    BookService bookService;

    @GetMapping("/book")
    public ResponseEntity<List<Book>> getBook(){
        return new ResponseEntity<>(bookService.getAllBook(), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getById(@PathVariable int id){
        try {
            return new ResponseEntity<>(bookService.getById(id), HttpStatus.OK);
        }catch(NoSuchElementFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/name/{title}")
    public ResponseEntity<Book> getByTitle(@PathVariable String title){
        try {
            return new ResponseEntity<>(bookService.getByTitle(title), HttpStatus.OK);
        }catch(NoSuchElementFoundException exception){
            return new ResponseEntity(exception.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/code/{codeISBN}")
    public ResponseEntity<Book> getByCode(@PathVariable String codeISBN){
        try {
            return new ResponseEntity<>(bookService.getByCode(codeISBN), HttpStatus.OK);
        }catch(NoSuchElementFoundException exception){
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/genre/{genre}")
    public ResponseEntity<List<BookDao>> getByGenre(@PathVariable String genre){
        try{
            return new ResponseEntity<>(bookService.getByGenre(genre), HttpStatus.OK);
        }catch(NoSuchElementFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/price/{price}")
    public ResponseEntity<List<BookDao>> getByPrice(@PathVariable String price){
        try{
            return new ResponseEntity<>(bookService.getByPrice(price), HttpStatus.OK);
        }catch(NoSuchElementFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/book")
    public ResponseEntity<Integer> addBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> modifyBook(@PathVariable int id, @RequestBody Book book){
        return new ResponseEntity<>(bookService.updateBook(id, book), HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Integer> deleteBook(@PathVariable int id){
        try{
            return new ResponseEntity<>(bookService.deleteBook(id), HttpStatus.NO_CONTENT);
        }catch (BookstoreException exception){
            return new ResponseEntity("There is something wrong with system.",HttpStatus.CONFLICT);
        }
    }

}