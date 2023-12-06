package com.phani.demo.controller;

import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phani.demo.Entity.Book;
import com.phani.demo.Entity.JsonResponse;
import com.phani.demo.Entity.Response;
import com.phani.demo.Services.bookServices;
import com.phani.demo.Services.responseService;
import com.phani.demo.repository.bookRepo;
import com.phani.demo.repository.responseRepo;

@RestController
@RequestMapping("/example")
public class BookController {

    @Autowired
    bookServices services;

    @Autowired
    responseService resServices;

    @PostMapping(path = "/create")
    public ResponseEntity<Response> create(@RequestBody Book book) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("../add").build().toUri();
        this.services.save(book);
        Response response = new Response("Book is saved", book.getBookId());
        this.resServices.save(response);
        return ResponseEntity.created(location).body(response);
    }

    @PostMapping("/updatePrice/{id}")
    public ResponseEntity<Object> update(@PathVariable int id,
            @RequestParam(name = "price", required = false) Object price) {
        int value=Integer.parseInt((price=="")? "0" :
    price.toString());
        this.services.updatePrice(value, id);
        Response response = new Response("Price is updated", value);
        resServices.save(response);
        return JsonResponse.reponseBuilder(response, HttpStatus.OK);
    }
    // @PostMapping("/updatePrice/{id}")
    // public ResponseEntity<Object> update(@PathVariable int id,
    // @RequestParam(name="price") String jsonParam) {
    // try {
    // String decodedJsonParam = URLDecoder.decode(jsonParam,
    // StandardCharsets.UTF_8.toString());
    // ObjectMapper objectMapper = new ObjectMapper();
    // Map<String, String> jsonData = objectMapper.readValue(decodedJsonParam,
    // new TypeReference<Map<String, String>>() {
    // });
    // String price = jsonData.get("price");
    // this.services.updatePrice(Integer.parseInt((price == null) ? "0" :
    // price.toString()), id);
    // Response response = new Response("Price is updated", 0);
    // resServices.save(response);
    // return JsonResponse.reponseBuilder(response, HttpStatus.OK);
    // } catch (Exception e) {
    // return ResponseEntity.status(400).body("Invalid JSON format");
    // }

    // }
}
