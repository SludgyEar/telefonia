package com.telefonia.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.telefonia.Entities.Contrato;

@Repository
public interface IContratoDAO {   // Métodos generados por JPA
    
    List<Contrato> findAll(); // Método que obtiene todos los contratos

    Optional<Contrato> findById(Short id);   // Método que obtiene un contrato por ID
}