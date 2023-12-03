package com.phani.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phani.demo.Entity.Book;
import com.phani.demo.Entity.JsonResponse;
import com.phani.demo.Entity.Response;
import com.phani.demo.repository.bookRepo;
import com.phani.demo.repository.responseRepo;

@Controller
@RequestMapping
public class BookController {

    @Autowired
    bookRepo repo;
    @Autowired
    responseRepo respRepo;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestParam Book book){
        this.repo.save(book);
        Response response= new Response(null, 0);
        return JsonResponse.reponseBuilder(response ,HttpStatus.OK);
    }
}

