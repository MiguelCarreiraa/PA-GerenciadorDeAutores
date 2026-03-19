package com.Carreira.PA_GerenciadorDeAutores.controllers;


import com.Carreira.PA_GerenciadorDeAutores.models.AutorModel;
import com.Carreira.PA_GerenciadorDeAutores.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<AutorModel> listarAutores(){
        return autorService.findAll();
    }

    @PostMapping
    public AutorModel criarAutor(@RequestBody AutorModel autorModel){
        return autorService.criarAutor(autorModel);
    }

    @GetMapping("/{id}")
    public AutorModel buscarAutor(@PathVariable Long id){
        return autorService.buscarAutorPorId(id);
    }

    @PutMapping("/{id}")
    public AutorModel atualizarAutor(@PathVariable Long id, @RequestBody AutorModel autorModel){
        return autorService.atualizarAutor(id, autorModel);
    }

    @DeleteMapping("/{id}")
    public void deletarAutor(@PathVariable Long id){
        autorService.deletarAutor(id);
    }
}
