package com.telefonia.controllers;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telefonia.controllers.dto.CoberturaRequestDTO;
import com.telefonia.controllers.dto.CoberturaResponseDTO;
import com.telefonia.service.ICoberturaService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/cobertura")
public class CoberturaController {
    
    @Autowired
    private ICoberturaService coberturaService;
    
    @PostMapping("/consultar")
    public ResponseEntity<CoberturaResponseDTO> consultarCobertura(@RequestBody CoberturaRequestDTO request){ 
        CoberturaResponseDTO response = coberturaService.consultarCobertura(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/consultar-async")
    public CompletableFuture<ResponseEntity<CoberturaResponseDTO>> consultarCoberturaAsync(
        @Valid @RequestBody CoberturaRequestDTO requestDTO) {
            return coberturaService.consultarCoberturaAsync(requestDTO)
            .thenApply(ResponseEntity::ok);
        }
    }    
    /*
     * RECIBIR SOLICITUDES DE DISPONIBILIDAD
     * SI LA HAY, SE BRINDA
     * SI NO LA HAY, SE GUARDA COMO PENDIENTE EN UNA TABLA, CHECA EN BASEA
     * UNA ACTUALIZACIÓN (EVENTO)
     * Al detectar un evento(PUT) se dispara "checar disponibilidad"
     * Recibo una direccion del broker, recibo una carga y recibo un id de
     * petición, yo almaceno las
     * peticiones para responderlas conforme estén disponibles.
     */