package com.telefonia.service.impl;

import java.time.LocalDateTime;
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
    // La capa de persistencia trabaja directamente con querys, se usa para obtener información para la respuesta
    @Autowired
    private ICoberturaDAO coberturaDAO;
    // Maneja logs
    private static final Logger logger = LoggerFactory.getLogger(CoberturaServiceImpl.class);
    
    @Override
    public CoberturaResponseDTO consultarCobertura(CoberturaRequestDTO requestDTO) {
        logger.info("Consultando cobertura para petición: {}", requestDTO.getIdPeticion());
        
        try {
            // Validar datos de dirección
            validarDireccion(requestDTO.getDireccionDTO());
            
            // Consultar cobertura usando la capa DAO
            Optional<CoberturaColonia> coberturaOpt = coberturaDAO.consultarCoberturaPorDireccion(
                requestDTO.getDireccionDTO()
            );
            
            // Construir respuesta
            return construirRespuesta(requestDTO, coberturaOpt);
            
        } catch (Exception e) {
            /*
             * Si falla se escribe en el log y se construye una respuesta en base al error,
             * así siempre se atienden las consultas, sea válida o no
             */
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
        /*
         * Método privado usado solo para construir un error en caso de que los campos código postal o colonia sean nullos
         */
        if (direccionDTO.getCodigoPostal() == null) {
            throw new IllegalArgumentException("El código postal es requerido");
        }
        if (direccionDTO.getColonia() == null || direccionDTO.getColonia().trim().isEmpty()) {
            throw new IllegalArgumentException("La colonia es requerida");
        }
    }
    
    private CoberturaResponseDTO construirRespuesta(CoberturaRequestDTO request, Optional<CoberturaColonia> coberturaOpt) {
        /*
         * Empezamos a construir la respuesta adjuntando el id de la petición que se responde,
         * la fecha en que se hace la consulta y la dirección que se consultaba
         */
        CoberturaResponseDTO response = new CoberturaResponseDTO();
        response.setIdPeticion(request.getIdPeticion());
        response.setFechaConsulta(LocalDateTime.now().toString());
        response.setDireccionDTO(request.getDireccionDTO());
        
        if (coberturaOpt.isPresent()) {
            // Si se encuentra cobertura se coloca la intensidad de señal (estado cobertura) y se confirma en las notas que la consulta fue atendida
            CoberturaColonia cobertura = coberturaOpt.get();
            response.setEstadoCobertura(cobertura.getEstadoCobertura().name());
            response.setNotas("Petición Atendida");
        } else {
            // Si no hay cobertura se indica el estado y la razón, además avisa que cuando el estado de cobertura cambie, se avisará al consultante
            response.setEstadoCobertura("NO");
            response.setNotas("No se encontró información de cobertura para esta dirección. Te dejaremos saber cuando eso cambie");
            // TODO : Si no hay cobertura guardamos los datos en una tabla para atender la consulta cuando haya servicio
        }
        
        return response;
    }
    
    private CoberturaResponseDTO construirRespuestaError(CoberturaRequestDTO request, String error) {
        // Método de apoyo para construir una respuesta en base a una petición errónea
        CoberturaResponseDTO response = new CoberturaResponseDTO();
        response.setIdPeticion(request.getIdPeticion());
        response.setFechaConsulta(LocalDateTime.now().toString());
        response.setEstadoCobertura("ERROR");
        response.setNotas("Error en la consulta: " + error);
        response.setDireccionDTO(request.getDireccionDTO());
        return response;
    }
    
}
