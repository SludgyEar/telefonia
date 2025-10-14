package com.telefonia.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la cobertura de una colonia específica.
 * 
 * Relaciona una {@link Colonia} con su estado de cobertura, notas adicionales y
 * la fecha de última actualización.
 *
 * Utiliza un enum interno {@link EstadoCobertura} para indicar el estado de
 * cobertura.
 *
 * @author {@link slutier}
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cobertura_colonia")
public class CoberturaColonia {
    /**
     * Identificador único para la tabla de cobertura en colonias
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cobertura_id")
    private Integer coberturaId;
    /**
     * Colonia relacionada a la cobertura
     * Relacion one to one
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "colonia_id", nullable = false, unique = true)
    private Colonia colonia;
    /**
     * Estado actual de la cobertura: SI, NO, PARCIAL, PROXIMAMENTE
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_cobertura", length = 20, nullable = false)
    private EstadoCobertura estadoCobertura;
    /**
     * Notas adicionales sobre la cobertura
     */
    @Column(name = "notas", columnDefinition = "TEXT")
    private String notas;
    /**
     * Fecha de actualización
     */
    @Column(name = "actualizado_en")
    private LocalDateTime actualizadoEn;
    /**
     * Posibles valores de estado de cobertura
     */
    public enum EstadoCobertura {
        SI, NO, PARCIAL, PROXIMAMENTE
    }

}
