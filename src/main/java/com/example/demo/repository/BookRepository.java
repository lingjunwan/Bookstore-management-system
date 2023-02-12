package com.example.demo.repository;

import com.example.demo.exception.*;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import java.sql.*;
import java.util.*;

@Repository
public class BookRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<com.example.demo.model.Book> getBook(){

        return jdbcTemplate.query(
            "select * from book",
            (rs, rowNum) ->
                new Book(
                    rs.getInt("bookId"),
                    rs.getString("title"),
                    rs.getString("codeISBN"),
                    rs.getString("genre"),
                    rs.getInt("price")
                )
        );
    }
    public Book findById(int id){
        try{
            String sql = "select * from book where bookId =?";
            Book fecthedBook = jdbcTemplate.queryForObject(
                sql, new Object[]{id},
                new RowMapper<Book>() {
                    @Override
                    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Book book = new Book();
                        book.setBookId(rs.getInt("bookId"));
                        book.setTitle((rs.getString("title")));
                        book.setCodeISBN(rs.getString("codeISBN"));
                        book.setGenre(rs.getString("genre"));
                        book.setPrice(rs.getDouble("price"));
                        return book;
                    }
                }
            );
            return fecthedBook;
        }catch(EmptyResultDataAccessException exception){
            throw new NoSuchElementFoundException("Book with id "+ id + " is not found.");
        }
    }

    public Book findByName(String title){
        try {
            String sql = "select * from book where title = ?";
            return jdbcTemplate.queryForObject(
                sql, new Object[]{title}, new RowMapper<Book>() {
                    @Override
                    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Book book = new Book();
                        book.setBookId(rs.getInt("bookId"));
                        book.setTitle((rs.getString("title")));
                        book.setCodeISBN(rs.getString("codeISBN"));
                        book.setGenre(rs.getString("genre"));
                        book.setPrice(rs.getDouble("price"));
                        return book;
                    }
                }
            );
        }catch(EmptyResultDataAccessException exception){
            throw new NoSuchElementFoundException("Book with title name "+ title+" is not found.");
        }
    }

    public Book findByCode(String codeISBN){
        try {
            String sql = "select * from book where codeISBN = ?";
            return jdbcTemplate.queryForObject(
                sql, new Object[]{codeISBN}, new RowMapper<Book>() {
                    @Override
                    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Book book = new Book();
                        book.setBookId(rs.getInt("bookId"));
                        book.setTitle((rs.getString("title")));
                        book.setCodeISBN(rs.getString("codeISBN"));
                        book.setGenre(rs.getString("genre"));
                        book.setPrice(rs.getDouble("price"));
                        return book;
                    }
                }
            );
        }
        catch(EmptyResultDataAccessException e){
            throw new NoSuchElementFoundException("Book with ISBN "+ codeISBN + " is not found.");
        }
    }

    public List<BookDao> getByGenre(String genre){
        String sql = "Select * from book where genre=?";

        List<BookDao> bookDao = jdbcTemplate.query(sql, new BookRowMapper(), genre);
        if(bookDao.isEmpty()){
            throw new NoSuchElementFoundException("Book in genre "+ genre+ "is not found.");
        }
        return bookDao;
    }

    public List<BookDao> getByPrice(String price){
        String sql = "Select * from book where price<?";

        List<BookDao> bookDao = jdbcTemplate.query(sql, new BookRowMapper(),price);
        if(bookDao.isEmpty()){
            throw new NoSuchElementFoundException("We do not have book with price less than "+ price+ ".");
        }
        return bookDao;
    }

    public int addBook(com.example.demo.model.Book book){
        jdbcTemplate.update(
            "INSERT INTO book (title, codeISBN, genre, price) VALUES (?,?,?,?)",
            book.getTitle(), book.getCodeISBN(), book.getGenre(), book.getPrice());
        return jdbcTemplate.queryForObject(
            "select max(bookId) from book", Integer.class);
    }

    public Book updateBook(int id, Book book){
        int result = jdbcTemplate.update("update book set title=? , codeISBN = ? , genre=? , price = ? where bookId = ?" , book.getTitle(), book.getCodeISBN(), book.getGenre(), book.getPrice(), id );
        if (result == 1){
            book.setBookId(id);
            return book;
        }
        return null;
    }

    public int deleteBook(int id){
        try{
            return jdbcTemplate.update(
                "delete from book where bookId = ?", id);
        }
        catch (DatabaseErrorException exception){
            throw new DatabaseErrorException(exception.getMessage());
        }
    }
}