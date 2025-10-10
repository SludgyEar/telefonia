package com.telefonia.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonia.Entities.CoberturaColonia;
import com.telefonia.persistence.ICoberturaColoniaDAO;
import com.telefonia.repository.CoberturaColoniaRepository;

@Component
public class CoberturaColoniaDAOImpl implements ICoberturaColoniaDAO {
    // Inyectamos el repositorio
    @Autowired
    private CoberturaColoniaRepository coberturaColoniaRepository;

    @Override
    public List<CoberturaColonia> findAll() {
        return (List<CoberturaColonia>) coberturaColoniaRepository.findAll();
    }

    @Override
    public Optional<CoberturaColonia> findById(Short id) {
        return coberturaColoniaRepository.findById(id);
    }
    
}