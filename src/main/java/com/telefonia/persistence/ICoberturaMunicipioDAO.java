package com.telefonia.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.telefonia.Entities.CoberturaMunicipio;

@Repository
public interface ICoberturaMunicipioDAO {   // Métodos generados por JPA
    
    List<CoberturaMunicipio> findAll(); // Método que obtiene todas las coberturas de municipio

    Optional<CoberturaMunicipio> findById(Short id);   // Método que obtiene una cobertura de municipio por ID
}