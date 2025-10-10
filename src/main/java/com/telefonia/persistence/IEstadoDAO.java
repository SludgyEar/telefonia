package com.telefonia.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.telefonia.Entities.Estado;

@Repository
public interface IEstadoDAO {   // Métodos generados por JPA
    
    List<Estado> findAll(); // Método que obtiene todos los estados

    Optional<Estado> findById(Byte clave);   // Método que obtiene un estado por clave
}
