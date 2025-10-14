package com.telefonia.persistence;

import java.util.Optional;

import com.telefonia.Entities.CoberturaColonia;
import com.telefonia.controllers.dto.DireccionDTO;

public interface ICoberturaDAO {
    /**
     * Interfaz para operaciones de acceso a datos relacionadas con la cobertura de
     * colonias, la implementación de los métodos trabaja directamente con los querys de JPA
     */
    Optional<CoberturaColonia> consultarCoberturaPorDireccion(DireccionDTO direccionDTO);
    Optional<CoberturaColonia> buscarPorCodigoPostalYColoniaExacta(Integer codigoPostal, String colonia);
    Optional<CoberturaColonia> buscarPorColoniaAproximada(String colonia, String municipio);
    Optional<CoberturaColonia> buscarPrimeraCoberturaPorCodigoPostal(Integer codigoPostal);

}
