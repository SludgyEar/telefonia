package com.telefonia.service;

import java.util.List;
import java.util.Optional;

import com.telefonia.Entities.Colonia;

public interface IColoniaService {
    // Contiene los mismos métodos que la interfaz DAO
    List<Colonia> findAll();

    Optional<Colonia> findById(Integer id);
}