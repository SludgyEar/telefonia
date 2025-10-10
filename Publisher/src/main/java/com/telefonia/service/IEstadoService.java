package com.telefonia.service;

import java.util.List;
import java.util.Optional;

import com.telefonia.Entities.Estado;

public interface IEstadoService {
    // Contiene los mismos métodos que la interfaz DAO
    List<Estado> findAll();

    Optional<Estado> findById(Byte clave);
}
