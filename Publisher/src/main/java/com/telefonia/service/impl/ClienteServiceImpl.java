package com.telefonia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonia.Entities.Cliente;
import com.telefonia.persistence.IClienteDAO;
import com.telefonia.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDAO clienteDAO;

    @Override
    public List<Cliente> findAll() {
        return clienteDAO.findAll();
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return clienteDAO.findById(id);
    }
    
}