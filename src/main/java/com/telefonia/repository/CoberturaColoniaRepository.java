package com.telefonia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telefonia.Entities.CoberturaColonia;

@Repository
public interface CoberturaColoniaRepository extends CrudRepository <CoberturaColonia, Short>{
    
}

