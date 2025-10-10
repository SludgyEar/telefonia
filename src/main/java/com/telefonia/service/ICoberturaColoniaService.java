package com.telefonia.service;

import java.util.List;
import java.util.Optional;

import com.telefonia.Entities.CoberturaColonia;

public interface ICoberturaColoniaService {
    // Contiene los mismos métodos que la interfaz DAO
    List<CoberturaColonia> findAll();

    Optional<CoberturaColonia> findById(Short id);
}