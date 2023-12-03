package com.phani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.phani.demo.Entity.Book;
import com.phani.demo.Entity.JsonResponse;
import com.phani.demo.Entity.Response;
import com.phani.demo.repository.bookRepo;


@Controller
public class BookController {

    @Autowired
    bookRepo repo;

    @Autowired
    JsonResponse service;

    @Bean
    @PostMapping(value="/path")
    public ResponseEntity<Object> save(@RequestBody Book book) {
        //TODO: process POST request
        
        this.repo.save(book);
        Response respose=new Response("null", 0);        
        return service.reponseBuilder(respose, HttpStatus.OK);
    }
    
}
