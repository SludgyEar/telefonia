package com.telefonia.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonia.Entities.Colonia;
import com.telefonia.persistence.IColoniaDAO;
import com.telefonia.repository.ColoniaRepository;

@Component
public class ColoniaDAOImpl implements IColoniaDAO {
    // Inyectamos el repositorio para hacer uso de los querys JPA
    @Autowired
    private ColoniaRepository coloniaRepository;

    @Override
    public List<Colonia> findAll() {
        return (List<Colonia>) coloniaRepository.findAll();
    }

    @Override
    public Optional<Colonia> findById(Integer id) {
        return coloniaRepository.findById(id);
    }
    
}