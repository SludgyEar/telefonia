package com.telefonia.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telefonia.Entities.CoberturaColonia;
import com.telefonia.Entities.Colonia;

import java.util.List;


@Repository
public interface CoberturaColoniaRepository extends CrudRepository <CoberturaColonia, Integer>{
    /**
     * Repositorio para la entidad {@link CoberturaColonia}.
     * Proporciona métodos para consultar cobertura de colonias por diferentes criterios,
     * utilizando querys jpa
     */
    Optional<CoberturaColonia> findByColonia(Colonia colonia);  // Búsca cobertura por colonia
    List<CoberturaColonia> findByColoniaMunicipioNombreContainingIgnoreCase(String municipio);  // Busca cobertura por colonias relacionada al nombre del municipio

}

