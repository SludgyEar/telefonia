package com.telefonia.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DireccionDTO {
    /**
     * Cuando un usuario quiere hacer una petición de cobertura tiene que mandar su información
     * de dirección la cual contiene los siguientes campos para agilizar la búsqueda.
     */
    private String colonia;
    private String codigoPostal;
    private String municipio;
    private String estado;
}
