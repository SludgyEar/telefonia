package com.telefonia.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telefonia.Entities.PeticionEspera;
@Repository
public interface PeticionEsperaRepository extends CrudRepository<PeticionEspera, Integer>{
    // Métodos GET POST PUT DELETE por defecto de CrudRepository
     // Buscar por lotes basado en zonas actualizadas
    @Query("SELECT p FROM PeticionEspera p WHERE " +
           "p.notificado = false AND (" +
           "   (p.codigoPostal IN :codigosPostales) OR " +
           "   (p.colonia IN :colonias) OR " +
           "   (p.municipio IN :municipios) OR " +
           "   (p.estado IN :estados)" +
           ")")
    List<PeticionEspera> findPeticionesPorZonasActualizadas(
            @Param("codigosPostales") List<String> codigosPostales,
            @Param("colonias") List<String> colonias,
            @Param("municipios") List<String> municipios,
            @Param("estados") List<String> estados);
    
    // Buscar peticiones no notificadas con paginación
    Page<PeticionEspera> findByNotificadoFalse(Pageable pageable);
}
