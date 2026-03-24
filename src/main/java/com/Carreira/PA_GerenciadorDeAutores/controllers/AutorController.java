package com.Carreira.PA_GerenciadorDeAutores.controllers;


import com.Carreira.PA_GerenciadorDeAutores.models.AutorModel;
import com.Carreira.PA_GerenciadorDeAutores.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<AutorModel>> listarAutores(){
        return ResponseEntity.ok(autorService.findAll());
    }

    @PostMapping
    public ResponseEntity<AutorModel> criarAutor(@RequestBody AutorModel autorModel){
        AutorModel novo = autorService.criarAutor(autorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorModel> buscarAutor(@PathVariable Long id){
        Optional<AutorModel> autor = autorService.buscarAutorPorId(id);

        if (autor.isPresent()) {
            return ResponseEntity.ok(autor.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorModel> atualizarAutor(@PathVariable Long id,
                                                     @RequestBody AutorModel autorModel){
        Optional<AutorModel> existente = autorService.buscarAutorPorId(id);

        if (existente.isPresent()) {
            AutorModel atualizado = autorService.atualizarAutor(id, autorModel);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAutor(@PathVariable Long id){
        Optional<AutorModel> existente = autorService.buscarAutorPorId(id);

        if (existente.isPresent()) {
            autorService.deletarAutor(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
