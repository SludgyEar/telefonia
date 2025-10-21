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
        /*
         * Método que se apoya de los métodos de búsqueda para buscar cobertura en una dirección dada
         * Si no se encuentra por código postal y colonia exacta, se busca por colonia y municipio y si no se puede
         * localizar exactamente la dirección se hace la consulta en el código postal ingresado, lo cual sería un aproximado
        */
        Optional<CoberturaColonia> cobertura;
        cobertura = buscarPorCodigoPostalYColoniaExacta(Integer.valueOf(direccionDTO.getCodigoPostal()), direccionDTO.getColonia());

        if (cobertura.isEmpty()) {
            cobertura = buscarPorColoniaAproximada(direccionDTO.getColonia(), direccionDTO.getMunicipio());
        }
        if (cobertura.isEmpty()) {
            cobertura = buscarPrimeraCoberturaPorCodigoPostal(Integer.valueOf(direccionDTO.getCodigoPostal()));
        }

        return cobertura;
    }
    @Override
    public Optional<CoberturaColonia> buscarPorCodigoPostalYColoniaExacta(Integer codigoPostal, String colonia) {
        // Búsca cobertura relacionada a un código postal y una colonia
        return coloniaRepository.findByCodigoPostalAndNombreIgnoreCase(codigoPostal, colonia).flatMap(col -> coberturaColoniaRepository.findByColonia(col));
    }
    @Override
    public Optional<CoberturaColonia> buscarPorColoniaAproximada(String colonia, String municipio) {
        // Buscar por nombre de colonia y municipio
        List<Colonia> colonias = coloniaRepository.findByNombreContainingIgnoreCaseAndMunicipioNombreContainingIgnoreCase(colonia, municipio);
        if (!colonias.isEmpty()) {
            // Si la lista no está vacía, se toma la primer colonia para hacer la búsqueda de cobertura
            return coberturaColoniaRepository.findByColonia(colonias.get(0));
        }
        return Optional.empty();
    }
    @Override
    public Optional<CoberturaColonia> buscarPrimeraCoberturaPorCodigoPostal(Integer codigoPostal) {
        // Busca TODAS las colonias con ese CP y toma la primera con cobertura
        List<Colonia> colonias = coloniaRepository.findByCodigoPostal(codigoPostal);

        for (Colonia colonia : colonias) {
            Optional<CoberturaColonia> cobertura = coberturaColoniaRepository.findByColonia(colonia);
            /*
             * Para mandar la primer colonia con cobertura relacionada al CP iteramos la
             * lista de colonias pertenecientes al CP dado.
             * Al encontrar la primer coincidencia entra al if y se rompe el ciclo con el return
             */ 
            if (cobertura.isPresent()) {
                return cobertura;
            }
        }
        return Optional.empty();
    }
}
