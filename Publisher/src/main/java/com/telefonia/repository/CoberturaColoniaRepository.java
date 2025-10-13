package com.telefonia.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telefonia.Entities.CoberturaColonia;
import com.telefonia.Entities.Colonia;

import java.util.List;


@Repository
public interface CoberturaColoniaRepository extends CrudRepository <CoberturaColonia, Integer>{

    Optional<CoberturaColonia> findByColonia(Colonia colonia);
    List<CoberturaColonia> findByColoniaMunicipioNombreContainingIgnoreCase(String municipio);

}

