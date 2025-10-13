package com.telefonia.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.telefonia.Entities.Servicio;

@Repository
public interface IServicioDAO {   // Métodos generados por JPA
    
    List<Servicio> findAll(); // Método que obtiene todos los servicios

    Optional<Servicio> findById(Integer id);   // Método que obtiene un servicio por ID
}