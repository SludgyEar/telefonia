package com.telefonia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telefonia.Entities.Estado;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Byte> {
    // AQUÍ SE ESCRIBEN LOS QUERYS PERSONALIZADOS
    // ES UNA INTERFACE POR LO QUE NO SE IMPLEMENTAN LOS MÉTODOS
}