package com.telefonia.controllers.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.telefonia.Entities.CoberturaColonia;
import com.telefonia.Entities.Contrato;
import com.telefonia.Entities.Municipio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColoniaDTO {
    private Integer id;

    private String nombre;

    private String asentamiento;

    private Integer codigoPostal;

    private BigDecimal latitud;

    private BigDecimal longitud;

    private Municipio municipio;

    @Builder.Default
    private List<Contrato> contratos = new ArrayList<>();

    private CoberturaColonia coberturaColonia;
}
