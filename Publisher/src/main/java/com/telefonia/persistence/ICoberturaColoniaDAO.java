package com.telefonia.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.telefonia.Entities.CoberturaColonia;

@Repository
public interface ICoberturaColoniaDAO {   // Métodos generados por JPA
    
    List<CoberturaColonia> findAll(); // Método que obtiene todas las coberturas de colonia

    Optional<CoberturaColonia> findById(Short id);   // Método que obtiene una cobertura de colonia por ID
}