package com.telefonia.Entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "colonias")
public class Colonia {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;

    @Column(name = "asentamiento", length = 40, nullable = false)
    private String asentamiento;

    @Column(name = "codigo_postal", nullable = false)
    private Integer codigoPostal;

    @Column(name = "latitud", precision = 16, scale = 13)
    private BigDecimal latitud;

    @Column(name = "longitud", precision = 16, scale = 13)
    private BigDecimal longitud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "municipio", nullable = false)
    private Municipio municipio;

    @OneToMany(mappedBy = "colonia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Contrato> contratos = new ArrayList<>();

    @OneToOne(mappedBy = "colonia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CoberturaColonia coberturaColonia;

}
