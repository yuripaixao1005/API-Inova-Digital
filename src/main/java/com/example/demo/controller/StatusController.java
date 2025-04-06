package com.example.demo.controller;

import com.example.demo.model.Status;
import com.example.demo.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusRepository repo;

    @GetMapping
    public List<Status> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Status criar(@RequestBody Status status) {
        return repo.save(status);
    }
}
