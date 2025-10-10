package com.telefonia.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonia.Entities.CoberturaEstado;
import com.telefonia.persistence.ICoberturaEstadoDAO;
import com.telefonia.repository.CoberturaEstadoRepository;

@Component
public class CoberturaEstadoDAOImpl implements ICoberturaEstadoDAO {
    // Inyectamos el repositorio
    @Autowired
    private CoberturaEstadoRepository coberturaEstadoRepository;

    @Override
    public List<CoberturaEstado> findAll() {
        return (List<CoberturaEstado>) coberturaEstadoRepository.findAll();
    }

    @Override
    public Optional<CoberturaEstado> findById(Short id) {
        return coberturaEstadoRepository.findById(id);
    }
    
}