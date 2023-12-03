package com.phani.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.phani.demo.Entity.Book;
import com.phani.demo.Entity.JsonResponse;
import com.phani.demo.Entity.Response;
import com.phani.demo.repository.bookRepo;


@Controller
public class BookController {

    @Autowired
    bookRepo repo;

    @RequestMapping(value ="/sum",method = RequestMethod.POST)
    public ResponseEntity<Object> save(@RequestBody Book book) {        
        this.repo.save(book);
        Response response=new Response("null", 0);        
        return JsonResponse.reponseBuilder(response, HttpStatus.OK);
    }
   
    
}
