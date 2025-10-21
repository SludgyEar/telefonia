package com.telefonia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telefonia.Entities.Colonia;

@Repository
public interface ColoniaRepository extends CrudRepository<Colonia, Integer> {
    /**
     * Repositorio para la entidad {@link Colonia}.
     * Proporciona métodos para consultar colonias por diferentes criterios, utilizando querys jpa
     */
    Optional<Colonia> findByCodigoPostalAndNombreIgnoreCase(Integer codigoPostal, String nombre);

    List<Colonia> findByNombreContainingIgnoreCaseAndMunicipioNombreContainingIgnoreCase(String colonia, String municipio);

    List<Colonia> findByCodigoPostal(Integer codigoPostal);

    List<Colonia> findByNombreContainingIgnoreCase(String colonia);
    
}