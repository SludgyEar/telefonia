package com.telefonia.service;

import java.util.List;
import java.util.Optional;

import com.telefonia.Entities.CoberturaMunicipio;

public interface ICoberturaMunicipioService {
    // Contiene los mismos métodos que la interfaz DAO
    List<CoberturaMunicipio> findAll();

    Optional<CoberturaMunicipio> findById(Short id);
}