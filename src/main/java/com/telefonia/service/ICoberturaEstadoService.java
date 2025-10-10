package com.telefonia.service;

import java.util.List;
import java.util.Optional;

import com.telefonia.Entities.CoberturaEstado;

public interface ICoberturaEstadoService {
    // Contiene los mismos métodos que la interfaz DAO
    List<CoberturaEstado> findAll();

    Optional<CoberturaEstado> findById(Short id);
}