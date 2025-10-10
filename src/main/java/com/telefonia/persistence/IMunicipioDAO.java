package com.telefonia.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.telefonia.Entities.Municipio;

@Repository
public interface IMunicipioDAO {
    
    List<Municipio> findAll();

    Optional<Municipio> findById(Integer id);

}
