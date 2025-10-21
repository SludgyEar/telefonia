package com.telefonia.service;

import java.util.List;
import java.util.Optional;

import com.telefonia.Entities.Estado;

public interface IEstadoService {
    // Métodos de búsqueda definidos por JPA
    List<Estado> findAll();
    Optional<Estado> findById(Byte clave);
}
