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
 * Entidad que representa la cobertura de un estado.
 *
 * Relaciona una {@link Estado} con su estado de cobertura, notas y la fecha de
 * última actualización. Utiliza un enum interno {@link EstadoCobertura}
 * para indicar si la cobertura es completa, parcial, inexistente o
 * "próximamente".
 *
 * Esta entidad está mapeada a la tabla `cobertura_estado`.
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cobertura_estado")
public class CoberturaEstado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cobertura_id")
    private Integer coberturaId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id", nullable = false, unique = true)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_cobertura", length = 20, nullable = false)
    private EstadoCobertura estadoCobertura;

    @Column(name = "notas", columnDefinition = "TEXT")
    private String notas;

    @Column(name = "actualizado_en")
    private LocalDateTime actualizadoEn;

    // Enum para estado de cobertura
    public enum EstadoCobertura {
        SI, NO, PARCIAL, PROXIMAMENTE
    }
}
