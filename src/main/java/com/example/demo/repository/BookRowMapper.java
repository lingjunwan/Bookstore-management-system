package com.example.demo.repository;

import org.springframework.jdbc.core.*;

import java.sql.*;

public class BookRowMapper implements RowMapper<BookDao> {

    @Override
    public BookDao mapRow(ResultSet rs, int rowNum) throws SQLException {

        BookDao book = new BookDao();
        book.setBookId(rs.getInt("bookId"));
        book.setTitle(rs.getString("title"));
        book.setCodeISBN(rs.getString("codeISBN"));
        book.setGenre(rs.getString("genre"));
        book.setPrice(rs.getDouble("price"));
        return book;
    }

}