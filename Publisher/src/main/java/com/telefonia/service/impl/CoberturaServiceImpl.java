package com.telefonia.service.impl;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.telefonia.Entities.CoberturaColonia;
import com.telefonia.controllers.dto.CoberturaRequestDTO;
import com.telefonia.controllers.dto.CoberturaResponseDTO;
import com.telefonia.controllers.dto.DireccionDTO;
import com.telefonia.persistence.ICoberturaDAO;
import com.telefonia.service.ICoberturaService;

@Service
@Transactional
public class CoberturaServiceImpl implements ICoberturaService{
    @Autowired
    private ICoberturaDAO coberturaDAO;
    
    private static final Logger logger = LoggerFactory.getLogger(CoberturaServiceImpl.class);
    
    @Override
    public CoberturaResponseDTO consultarCobertura(CoberturaRequestDTO requestDTO) {
        logger.info("Consultando cobertura para petición: {}", requestDTO.getIdPeticion());
        
        try {
            // 1. Validar datos de entrada
            validarDireccion(requestDTO.getDireccionDTO());
            
            // 2. Consultar cobertura usando DAO
            Optional<CoberturaColonia> coberturaOpt = coberturaDAO.consultarCoberturaPorDireccion(
                requestDTO.getDireccionDTO()
            );
            
            // 3. Construir respuesta
            return construirRespuesta(requestDTO, coberturaOpt);
            
        } catch (Exception e) {
            logger.error("Error consultando cobertura para petición: {}", requestDTO.getIdPeticion(), e);
            return construirRespuestaError(requestDTO, e.getMessage());
        }
    }
    
    @Async
    @Override
    public CompletableFuture<CoberturaResponseDTO> consultarCoberturaAsync(CoberturaRequestDTO requestDTO) {
        return CompletableFuture.completedFuture(consultarCobertura(requestDTO));
    }
    
    private void validarDireccion(DireccionDTO direccionDTO) {
        if (direccionDTO.getCodigoPostal() == null) {
            throw new IllegalArgumentException("El código postal es requerido");
        }
        if (direccionDTO.getColonia() == null || direccionDTO.getColonia().trim().isEmpty()) {
            throw new IllegalArgumentException("La colonia es requerida");
        }
    }
    
    private CoberturaResponseDTO construirRespuesta(CoberturaRequestDTO request, Optional<CoberturaColonia> coberturaOpt) {
        CoberturaResponseDTO response = new CoberturaResponseDTO();
        response.setIdPeticion(request.getIdPeticion());
        response.setDireccionDTO(request.getDireccionDTO());
        
        if (coberturaOpt.isPresent()) {
            CoberturaColonia cobertura = coberturaOpt.get();
            response.setEstadoCobertura(cobertura.getEstadoCobertura().name());
        } else {
            response.setEstadoCobertura("NO");
        }
        
        return response;
    }
    
    private CoberturaResponseDTO construirRespuestaError(CoberturaRequestDTO request, String error) {
        CoberturaResponseDTO response = new CoberturaResponseDTO();
        response.setIdPeticion(request.getIdPeticion());
        response.setEstadoCobertura("ERROR");
        response.setDireccionDTO(request.getDireccionDTO());
        return response;
    }
    
}
