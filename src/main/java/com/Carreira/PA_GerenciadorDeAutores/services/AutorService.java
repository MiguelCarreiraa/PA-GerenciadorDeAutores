package com.Carreira.PA_GerenciadorDeAutores.services;

import com.Carreira.PA_GerenciadorDeAutores.models.AutorModel;
import com.Carreira.PA_GerenciadorDeAutores.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<AutorModel> findAll(){
        return autorRepository.findAll();
    }

    public AutorModel criarAutor(AutorModel autor){
        return autorRepository.save(autor);
    }

    public Optional<AutorModel> buscarAutorPorId(Long id){
        return autorRepository.findById(id);
    }

    public AutorModel atualizarAutor(Long id, AutorModel autorModel){
        AutorModel model = autorRepository.findById(id).get();

        model.setNome(autorModel.getNome());
        model.setDataNascimento(autorModel.getDataNascimento());
        model.setNacionalidade(autorModel.getNacionalidade());

        return autorRepository.save(model);
    }

    public void deletarAutor(Long id){
        autorRepository.deleteById(id);
    }
}
