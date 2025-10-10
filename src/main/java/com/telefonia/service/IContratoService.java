package com.telefonia.service;

import java.util.List;
import java.util.Optional;

import com.telefonia.Entities.Contrato;

public interface IContratoService {
    // Contiene los mismos métodos que la interfaz DAO
    List<Contrato> findAll();

    Optional<Contrato> findById(Short id);
}