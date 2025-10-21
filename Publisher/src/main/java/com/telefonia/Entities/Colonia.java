package com.telefonia.Entities;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Representa una colonia dentro de un municipio.
 *
 * Contiene información geográfica y administrativa: nombre, tipo de
 * asentamiento, código postal y coordenadas (latitud/longitud). Cada
 * {@link Colonia} pertenece a un {@link Municipio} (relación ManyToOne) y
 * puede tener una entidad asociada {@link CoberturaColonia} que indica el
 * estado de cobertura del servicio en esa colonia.
 *
 * Mapeada a la tabla `colonias`.
 */
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

    @OneToOne(mappedBy = "colonia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CoberturaColonia coberturaColonia;

}
