package com.telefonia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonia.Entities.Servicio;
import com.telefonia.persistence.IServicioDAO;
import com.telefonia.service.IServicioService;

@Service
public class ServicioServiceImpl implements IServicioService {

    @Autowired
    private IServicioDAO servicioDAO;

    @Override
    public List<Servicio> findAll() {
        return servicioDAO.findAll();
    }

    @Override
    public Optional<Servicio> findById(Short id) {
        return servicioDAO.findById(id);
    }
    
}