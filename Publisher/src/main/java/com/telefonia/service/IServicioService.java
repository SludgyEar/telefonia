package com.telefonia.service;

import java.util.List;
import java.util.Optional;

import com.telefonia.Entities.Servicio;

public interface IServicioService {
    // Contiene los mismos métodos que la interfaz DAO
    List<Servicio> findAll();

    Optional<Servicio> findById(Integer id);
}