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
public class ClienteDTO {
    // Sin uso
    private int id;
    private String nombre;
    private DireccionDTO direccion;

}