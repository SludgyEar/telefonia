package com.telefonia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telefonia.Entities.Colonia;

@Repository
public interface ColoniaRepository extends CrudRepository<Colonia, Integer> {

    List<Colonia> findByCodigoPostal(Integer codigoPostal);
    Optional<Colonia> findByCodigoPostalAndNombreContainingIgnoreCase(Integer codigoPostal, String colonia);
    List<Colonia> findByNombreContainingIgnoreCaseAndMunicipioNombreContainingIgnoreCase(String colonia, String municipio);
    
}