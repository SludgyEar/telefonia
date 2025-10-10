package com.telefonia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telefonia.Entities.CoberturaEstado;
@Repository
public interface CoberturaEstadoRepository extends CrudRepository <CoberturaEstado, Short>{
    
}
