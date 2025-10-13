package com.telefonia.service;

import java.util.concurrent.CompletableFuture;

import com.telefonia.controllers.dto.CoberturaRequestDTO;
import com.telefonia.controllers.dto.CoberturaResponseDTO;

public interface ICoberturaService {

    /**
     * Consulta la cobertura para una dirección específica
     * 
     * @param requestDTO Datos de la dirección a consultar
     * @return Respuesta con el estado de cobertura
     */
    CoberturaResponseDTO consultarCobertura(CoberturaRequestDTO requestDTO);

    /**
     * Consulta cobertura de forma asíncrona
     * 
     * @param requestDTO Datos de la dirección
     * @return Future con la respuesta de cobertura
     */
    CompletableFuture<CoberturaResponseDTO> consultarCoberturaAsync(CoberturaRequestDTO requestDTO);
}
