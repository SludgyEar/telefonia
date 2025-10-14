package com.telefonia.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "peticiones_espera")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeticionEspera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "ip", nullable = false, length = 15)
    private String ip;
    
    @Column(name = "codigo_postal", nullable = false, length = 5)
    private String codigoPostal;
    
    @Column(name = "colonia", length = 60, nullable = false)
    private String colonia;
    
    @Column(name = "municipio", length = 60, nullable = false)
    private String municipio;
    
    @Column(name = "estado", length = 60, nullable = false)
    private String estado;
    
    @Column(name = "id_peticion", nullable = false)
    private Integer idPeticion;
    
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    
    @Column(name = "notificado")
    private Boolean notificado;

}
