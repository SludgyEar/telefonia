package com.telefonia.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.telefonia.Entities.Colonia;

@Repository
public interface IColoniaDAO {   // Métodos generados por JPA
    
    List<Colonia> findAll(); // Método que obtiene todas las colonias

    Optional<Colonia> findById(Integer id);   // Método que obtiene una colonia por ID
}