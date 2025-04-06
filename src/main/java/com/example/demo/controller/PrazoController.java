package com.example.demo.controller;

import com.example.demo.model.Prazo;
import com.example.demo.repository.PrazoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prazos")
public class PrazoController {

    @Autowired
    private PrazoRepository repo;

    @GetMapping
    public List<Prazo> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Prazo criar(@RequestBody Prazo prazo) {
        return repo.save(prazo);
    }
}
