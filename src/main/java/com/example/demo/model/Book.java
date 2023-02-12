package com.example.demo.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    private int bookId;
    private String title;
    private String codeISBN;
    private String genre;
    private double price;

}