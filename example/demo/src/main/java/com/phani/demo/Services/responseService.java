package com.phani.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phani.demo.Entity.Response;
import com.phani.demo.repository.responseRepo;

@Service
public class responseService {
    private responseRepo repo;

    @Autowired
    public responseService(responseRepo repo) {

        this.repo = repo;
    }

    public void save(Response response){
        this.repo.save(response);
    }

}
