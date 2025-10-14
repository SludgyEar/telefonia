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
        
        cobertura = buscarPorCodigoPostalYColoniaExacta(
                Integer.valueOf(direccionDTO.getCodigoPostal()),
                direccionDTO.getColonia());

        if (cobertura.isEmpty()) {
            cobertura = buscarPorColoniaAproximada(
                    direccionDTO.getColonia(),
                    direccionDTO.getMunicipio());
        }
        if (cobertura.isEmpty()) {
            cobertura = buscarPrimeraCoberturaPorCodigoPostal(Integer.valueOf(direccionDTO.getCodigoPostal()));
        }

        return cobertura;
    }
    @Override
    public Optional<CoberturaColonia> buscarPorCodigoPostalYColoniaExacta(Integer codigoPostal, String colonia) {
        return coloniaRepository.findByCodigoPostalAndNombreIgnoreCase(codigoPostal, colonia)
                .flatMap(col -> coberturaColoniaRepository.findByColonia(col));
    }
    @Override
    public Optional<CoberturaColonia> buscarPorColoniaAproximada(String colonia, String municipio) {
        // Buscar por nombre de colonia y municipio
        List<Colonia> colonias = coloniaRepository
                .findByNombreContainingIgnoreCaseAndMunicipioNombreContainingIgnoreCase(
                        colonia, municipio);

        if (!colonias.isEmpty()) {
            // Tomar la primera coincidencia
            return coberturaColoniaRepository.findByColonia(colonias.get(0));
        }
        return Optional.empty();
    }
    @Override
    public Optional<CoberturaColonia> buscarPrimeraCoberturaPorCodigoPostal(Integer codigoPostal) {
        // Buscar TODAS las colonias con ese CP y tomar la primera que tenga cobertura
        List<Colonia> colonias = coloniaRepository.findByCodigoPostal(codigoPostal);

        for (Colonia colonia : colonias) {
            Optional<CoberturaColonia> cobertura = coberturaColoniaRepository.findByColonia(colonia);
            if (cobertura.isPresent()) {
                return cobertura;
            }
        }
        return Optional.empty();
    }
}
