package com.telefonia.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.telefonia.Entities.CoberturaColonia;
import com.telefonia.Entities.Colonia;
import com.telefonia.controllers.dto.DireccionDTO;
import com.telefonia.persistence.ICoberturaDAO;
import com.telefonia.repository.CoberturaColoniaRepository;
import com.telefonia.repository.ColoniaRepository;

@Repository
public class CoberturaDAOImpl implements ICoberturaDAO{
    @Autowired
    private CoberturaColoniaRepository coberturaColoniaRepository;
    @Autowired
    private ColoniaRepository coloniaRepository;

    @Override
    public Optional<CoberturaColonia> consultarCoberturaPorDireccion(DireccionDTO direccionDTO) {
        Optional<CoberturaColonia> cobertura;
        
        // Buscar por código postal y colonia exacta
        cobertura = buscarPorCodigoPostalYColonia(
            Integer.valueOf(direccionDTO.getCodigoPostal()), 
            direccionDTO.getColonia()
        );
        
        // Si no encuentra, buscar solo por código postal
        if (cobertura.isEmpty()) {
            cobertura = buscarPorCodigoPostal(Integer.valueOf(direccionDTO.getCodigoPostal()));
        }
        
        // Si aún no encuentra, buscar por municipio
        if (cobertura.isEmpty()) {
            cobertura = buscarPorMunicipio(direccionDTO.getMunicipio());
        }
        
        return cobertura;
    }
    @Override
    public Optional<CoberturaColonia> buscarPorCodigoPostalYColonia(Integer codigoPostal, String colonia) {
        return coloniaRepository.findByCodigoPostalAndNombreContainingIgnoreCase(codigoPostal, colonia)
                .flatMap(col -> coberturaColoniaRepository.findByColonia(col));
    }
    @Override
    public Optional<CoberturaColonia> buscarPorCodigoPostal(Integer codigoPostal) {
        List<Colonia> colonias = coloniaRepository.findByCodigoPostal(codigoPostal);
        if (!colonias.isEmpty()) {
            return coberturaColoniaRepository.findByColonia(colonias.get(0));
        }
        return Optional.empty();
    }
    @Override
    public Optional<CoberturaColonia> buscarPorMunicipio(String municipio) {
        // Implementar búsqueda por municipio
        return coberturaColoniaRepository.findByColoniaMunicipioNombreContainingIgnoreCase(municipio)
                .stream()
                .findFirst();
    }
}
