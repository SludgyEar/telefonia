package com.telefonia.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonia.Entities.Servicio;
import com.telefonia.persistence.IServicioDAO;
import com.telefonia.repository.ServicioRepository;

@Component
public class ServicioDAOImpl implements IServicioDAO {
    // Inyectamos el repositorio
    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<Servicio> findAll() {
        return (List<Servicio>) servicioRepository.findAll();
    }

    @Override
    public Optional<Servicio> findById(Short id) {
        return servicioRepository.findById(id);
    }
    
}