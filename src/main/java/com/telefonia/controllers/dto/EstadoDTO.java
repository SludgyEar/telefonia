package com.telefonia.controllers.dto;

import java.util.ArrayList;
import java.util.List;

import com.telefonia.Entities.CoberturaEstado;
import com.telefonia.Entities.Municipio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadoDTO {
    private Byte clave;

    private String nombre;
    
    private String abreviacion;
    
    private Integer cpMin;
    
    private Integer cpMax;
    @Builder.Default
    private List<Municipio> municipios = new ArrayList<>();
    
    private CoberturaEstado coberturaEstado;
}
