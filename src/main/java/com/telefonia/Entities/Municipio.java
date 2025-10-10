package com.telefonia.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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
@Entity
@Table(name = "municipios")
public class Municipio {
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;
    
    @Column(name = "cp_min", nullable = false)
    private Integer cpMin;
    
    @Column(name = "cp_max", nullable = false)
    private Integer cpMax;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "huso_horario")
    private HusoHorario husoHorario;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado", nullable = false)
    private Estado estado;
    
    @OneToMany(mappedBy = "municipio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Colonia> colonias = new ArrayList<>();
    
    @OneToOne(mappedBy = "municipio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
