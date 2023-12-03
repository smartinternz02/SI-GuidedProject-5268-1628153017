package com.phani.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="book")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {

    @Id
    @Column(name="book_id")
    private int bookId;
    @Column(name="book_name")
    private String bookName;
    @Column(name="author")
    private String author;
    @Column(name="price")
    private int price;
   
}
