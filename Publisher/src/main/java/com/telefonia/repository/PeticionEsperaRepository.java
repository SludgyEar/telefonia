package com.telefonia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telefonia.Entities.PeticionEspera;
@Repository
public interface PeticionEsperaRepository extends CrudRepository<PeticionEspera, Integer>{
    // Métodos GET POST PUT DELETE por defecto de CrudRepository
}
