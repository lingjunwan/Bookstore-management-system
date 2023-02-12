package com.example.demo.repository;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookDao {
    private int bookId;
    private String title;
    private String codeISBN;
    private String genre;
    private double price;

}