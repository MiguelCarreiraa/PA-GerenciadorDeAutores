package com.Carreira.PA_GerenciadorDeAutores.repositories;

import com.Carreira.PA_GerenciadorDeAutores.models.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorModel, Long> {
}
