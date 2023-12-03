package com.phani.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phani.demo.Entity.Response;

public interface responseRepo extends JpaRepository<Response,Integer>{ 
} 
