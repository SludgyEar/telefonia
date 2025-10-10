package com.telefonia.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
@Table(name = "estados")
public class Estado {
    @Id
    @Column(name = "clave")
    private Byte clave;

    @Column(name = "nombre", length = 33, nullable = false)
    private String nombre;
    
    @Column(name = "abreviacion", length = 4, nullable = false)
    private String abreviacion;
    
    @Column(name = "cp_min", nullable = false)
    private Integer cpMin;
    
    @Column(name = "cp_max", nullable = false)
    private Integer cpMax;
    
    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Municipio> municipios = new ArrayList<>();
    
    @OneToOne(mappedBy = "estado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CoberturaEstado coberturaEstado;
}
