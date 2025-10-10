package com.telefonia.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonia.Entities.Contrato;
import com.telefonia.persistence.IContratoDAO;
import com.telefonia.repository.ContratoRepository;

@Component
public class ContratoDAOImpl implements IContratoDAO {
    // Inyectamos el repositorio
    @Autowired
    private ContratoRepository contratoRepository;

    @Override
    public List<Contrato> findAll() {
        return (List<Contrato>) contratoRepository.findAll();
    }

    @Override
    public Optional<Contrato> findById(Short id) {
        return contratoRepository.findById(id);
    }
    
}