package com.telefonia.persistence;

import java.util.Optional;

import com.telefonia.Entities.CoberturaColonia;
import com.telefonia.controllers.dto.DireccionDTO;

public interface ICoberturaDAO {
    
    Optional<CoberturaColonia> consultarCoberturaPorDireccion(DireccionDTO direccionDTO);
    Optional<CoberturaColonia> buscarPorCodigoPostalYColonia(Integer codigoPostal, String colonia);
    Optional<CoberturaColonia> buscarPorCodigoPostal(Integer codigoPostal);
    Optional<CoberturaColonia> buscarPorMunicipio(String municipio);

}
