package com.telefonia.service;

import java.util.List;
import java.util.Optional;

import com.telefonia.Entities.Colonia;

public interface IColoniaService {
    // Métodos de búsqueda definidos por JPA
    List<Colonia> findAll();
    Optional<Colonia> findById(Integer id);
}