package com.telefonia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonia.Entities.CoberturaEstado;
import com.telefonia.persistence.ICoberturaEstadoDAO;
import com.telefonia.service.ICoberturaEstadoService;

@Service
public class CoberturaEstadoServiceImpl implements ICoberturaEstadoService {

    @Autowired
    private ICoberturaEstadoDAO coberturaEstadoDAO;

    @Override
    public List<CoberturaEstado> findAll() {
        return coberturaEstadoDAO.findAll();
    }

    @Override
    public Optional<CoberturaEstado> findById(Short id) {
        return coberturaEstadoDAO.findById(id);
    }
    
}