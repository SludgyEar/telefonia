package com.telefonia.service;

import java.util.List;
import java.util.Optional;

import com.telefonia.Entities.Cliente;

public interface IClienteService {
    // Contiene los mismos métodos que la interfaz DAO
    List<Cliente> findAll();

    Optional<Cliente> findById(Short id);
}