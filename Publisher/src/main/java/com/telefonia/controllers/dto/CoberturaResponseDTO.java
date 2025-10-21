package com.telefonia.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CoberturaResponseDTO {
    private int idPeticion;
    private DireccionDTO direccionDTO;
    private String estadoCobertura; // SI, NO, PARCIAL, PROXIMAMANTE
    private String notas;
    private String fechaConsulta;
}
