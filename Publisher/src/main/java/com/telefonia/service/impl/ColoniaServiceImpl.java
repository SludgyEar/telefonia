package com.telefonia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonia.Entities.Colonia;
import com.telefonia.persistence.IColoniaDAO;
import com.telefonia.service.IColoniaService;

@Service
public class ColoniaServiceImpl implements IColoniaService {
    /*
     * Implementación de métodos de búsqueda
     */
    @Autowired
    private IColoniaDAO coloniaDAO;

    @Override
    public List<Colonia> findAll() {
        return coloniaDAO.findAll();
    }

    @Override
    public Optional<Colonia> findById(Integer id) {
        return coloniaDAO.findById(id);
    }
    
}