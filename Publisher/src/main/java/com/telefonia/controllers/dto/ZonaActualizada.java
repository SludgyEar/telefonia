package com.telefonia.controllers.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ZonaActualizada {
    private String codigoPostal;
    private String colonia;
    private String municipio;
    private String estado;
    private LocalDateTime fechaActualizacion;
}