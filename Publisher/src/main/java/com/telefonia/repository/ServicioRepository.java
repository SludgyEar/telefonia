package com.telefonia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telefonia.Entities.Servicio;

@Repository
public interface ServicioRepository extends CrudRepository<Servicio, Integer> {
    // AQUÍ SE ESCRIBEN LOS QUERYS PERSONALIZADOS
    // ES UNA INTERFACE POR LO QUE NO SE IMPLEMENTAN LOS MÉTODOS
}