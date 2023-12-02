package com.phani.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phani.Entity.Book;

import jakarta.transaction.Transactional;

@Repository
public interface bookRepo extends JpaRepository<Book,Integer> {

    List<Book> findAll();
    List<Book> findByAuthor(String author);
    Book findByBookName(String bookName);

   @Query(nativeQuery = true,value = "update bajaj set price=:newprice where book_id=:newBookId")
   @Modifying
   @Transactional
   int changePrice(@Param("newprice") int price,@Param("newBookId") int bookId);

   @Query("from book where author=:srch")
   List<Book> searchUsingAuthor(@Param("srch") String author);
    
}