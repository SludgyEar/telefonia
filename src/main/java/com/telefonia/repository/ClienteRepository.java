package com.telefonia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telefonia.Entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Short>{
    /*
     * AQUÍ SE ESCRIBEN LOS QUERYS PERSONALIZADOS
     * ES UNA INTERFACE POR LO QUE NO SE IMPLEMENTAN LOS MÉTODOS
     * Al usar JPA tenemos la capacidad de crear métodos que mapea un query con la sig sintaxis:
     * [acción]By[propiedad][condición][operador][propiedad]...
     */
}
