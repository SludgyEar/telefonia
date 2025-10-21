package com.telefonia.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.telefonia.Entities.Municipio;

@Repository
public interface IMunicipioDAO { // Métodos generados por JPA para obtener todos los municipios o un municipio por id
    
    List<Municipio> findAll();

    Optional<Municipio> findById(Integer id);

}
