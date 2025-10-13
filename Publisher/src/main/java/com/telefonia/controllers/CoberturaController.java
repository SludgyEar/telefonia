package com.telefonia.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telefonia.controllers.dto.CoberturaRequestDTO;
import com.telefonia.controllers.dto.DireccionDTO;

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
    @PostMapping()
    public ResponseEntity<?> getCoberturaRequest(@RequestBody CoberturaRequestDTO request){
        /*
         * Request: {ip:"", direccionDTO:{colonia, codigoPostal, municipio, estado}, idPeticion:1}
         */
        String ip = request.getIp();
        DireccionDTO direccionDTO = request.getDireccionDTO();
        int idPeticion = request.getIdPeticion();
        // Rescatamos la información por separado

        return ResponseEntity.ok().body("recibido");
    }
    
}
