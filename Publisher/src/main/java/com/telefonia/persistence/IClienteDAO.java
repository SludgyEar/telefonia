package com.telefonia.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.telefonia.Entities.Cliente;

@Repository
public interface IClienteDAO {   // Métodos generados por JPA
    
    List<Cliente> findAll(); // Método que obtiene todos los clientes

    Optional<Cliente> findById(Short id);   // Método que obtiene un cliente por ID
}