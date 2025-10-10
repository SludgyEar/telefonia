package com.telefonia.controllers.dto;

import java.util.ArrayList;
import java.util.List;

import com.telefonia.Entities.CoberturaMunicipio;
import com.telefonia.Entities.Colonia;
import com.telefonia.Entities.Estado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MunicipioDTO {
    private Integer id;
    
    private String nombre;
    
    private Integer cpMin;
    
    private Integer cpMax;
    
    private HusoHorario husoHorario;
    
    private Estado estado;
    
    @Builder.Default
    private List<Colonia> colonias = new ArrayList<>();
    
    private CoberturaMunicipio coberturaMunicipio;
    
    // Enum para huso horario
    public enum HusoHorario {
        TIEMPO_CENTRO,
        TIEMPO_NOROESTE,
        TIEMPO_PACIFICO,
        TIEMPO_SURESTE,
        TIEMPO_CENTRO_FRONTERA,
        TIEMPO_NOROESTE_FRONTERA,
        TIEMPO_PACIFICO_FRONTERA,
        TIEMPO_PACIFICO_SONORA
    }
}
