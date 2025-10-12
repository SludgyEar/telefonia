package com.telefonia.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telefonia.controllers.dto.CoberturaRequestDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/cobertura")
public class CoberturaController {
    /*
        *         PUT : ACTUALIZAR
        *         POST: RECIBIR SOLICITUDES DE DISPONIBILIDAD
        *         SI LA HAY, SE BRINDA
        *         SI NO LA HAY, SE GUARDA COMO PENDIENTE EN UNA TABLA, CHECA EN BASEA
        *         UNA ACTUALIZACIÓN (EVENTO)
        *         Al detectar un evento(PUT) se dispara "checar disponibilidad"
        * 
        *         Recibo una direccion del broker, recibo una carga y recibo un id de
        *         petición, yo almaceno las
        *         peticiones para responderlas conforme estén disponibles.
     * 
     */
    @PostMapping("path")
    public ResponseEntity<?> getCoberturaRequest(@RequestBody CoberturaRequestDTO request){
        /*
         * Request: {ip:"", direccionDTO:{}, id:1}
         */
        return null;
    }
    
}
