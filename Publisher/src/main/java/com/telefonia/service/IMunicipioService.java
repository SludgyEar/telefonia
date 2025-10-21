package com.telefonia.service;

import java.util.List;
import java.util.Optional;

import com.telefonia.Entities.Municipio;

public interface IMunicipioService {
    // Métodos de búsqueda definidos por JPA y CrudRepository
    List<Municipio> findAll();
    Optional<Municipio> findById(Integer id);
}