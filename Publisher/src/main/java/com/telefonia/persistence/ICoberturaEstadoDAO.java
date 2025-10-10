package com.telefonia.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.telefonia.Entities.CoberturaEstado;

@Repository
public interface ICoberturaEstadoDAO {   // Métodos generados por JPA
    
    List<CoberturaEstado> findAll(); // Método que obtiene todas las coberturas de estado

    Optional<CoberturaEstado> findById(Short id);   // Método que obtiene una cobertura de estado por ID
}