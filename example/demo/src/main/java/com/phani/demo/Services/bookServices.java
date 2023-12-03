package com.phani.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phani.demo.Entity.Book;
import com.phani.demo.repository.bookRepo;

@Service
public class bookServices {
    private bookRepo repo;

    @Autowired
    public bookServices(bookRepo repo){
        this.repo=repo;
    }
    public bookServices(){
        super();
    }
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
