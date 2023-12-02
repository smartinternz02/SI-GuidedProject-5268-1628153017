package com.phani.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phani.Entity.Book;
import com.phani.repository.bookRepo;

@Service
public class bookServices {
    bookRepo repo;
    public void save(Book obj){
        this.repo.save(obj);
    }
    public List<Book> saveBooks(List<Book> books){
        return this.repo.saveAll(books);
    }
    public int updatePrice(int price,int bookId){
        return this.repo.changePrice(price,bookId);
    }
    public List<Book> searchBooksByAuthor(String authorName){
        return this.repo.searchUsingAuthor(authorName);
    }
    public Book findByBookName(String bookName){
        return this.repo.findByBookName(bookName);
    }
    public List<Book> findAll(){
        return this.repo.findAll();
    }
}
