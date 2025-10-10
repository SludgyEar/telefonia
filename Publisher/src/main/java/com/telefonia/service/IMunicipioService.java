package com.telefonia.service;

import java.util.List;
import java.util.Optional;

import com.telefonia.Entities.Municipio;

public interface IMunicipioService {
    // Contiene los mismos métodos que la interfaz DAO
    List<Municipio> findAll();

    Optional<Municipio> findById(Integer id);
}