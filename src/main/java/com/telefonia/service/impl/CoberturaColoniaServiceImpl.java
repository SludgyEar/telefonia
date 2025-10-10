package com.telefonia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonia.Entities.CoberturaColonia;
import com.telefonia.persistence.ICoberturaColoniaDAO;
import com.telefonia.service.ICoberturaColoniaService;

@Service
public class CoberturaColoniaServiceImpl implements ICoberturaColoniaService {

    @Autowired
    private ICoberturaColoniaDAO coberturaColoniaDAO;

    @Override
    public List<CoberturaColonia> findAll() {
        return coberturaColoniaDAO.findAll();
    }

    @Override
    public Optional<CoberturaColonia> findById(Short id) {
        return coberturaColoniaDAO.findById(id);
    }
    
}