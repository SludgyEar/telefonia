package com.telefonia.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonia.Entities.Cliente;
import com.telefonia.persistence.IClienteDAO;
import com.telefonia.repository.ClienteRepository;

@Component
public class ClienteDAOImpl implements IClienteDAO {
    // Inyectamos el repositorio
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return clienteRepository.findById(id);
    }
    
}