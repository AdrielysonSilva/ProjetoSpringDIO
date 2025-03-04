package com.locadora.catalogo_filmes.controller;

import com.locadora.catalogo_filmes.model.Filme;
import com.locadora.catalogo_filmes.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<Filme> getAllFilmes() {
        return filmeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> getFilmeById(@PathVariable Long id) {
        Optional<Filme> filme = filmeService.findById(id);
        return filme.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Filme> createFilme(@RequestBody Filme filme) {
        Filme savedFilme = filmeService.save(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFilme);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilme(@PathVariable Long id) {
        filmeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
