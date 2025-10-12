package com.telefonia.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoberturaRequestDTO {
    /**
     * Clase que define el DTO de los request que llegan al Publisher
     * Consta de:
     * Carga: direccionDTO
     * broker ip: dirección ip del broker que hace la solicitud
     * peticion id: identificador de la petición el broker
     */
    private String ip;
    private DireccionDTO direccionDTO;
    private int idPeticion;
}
