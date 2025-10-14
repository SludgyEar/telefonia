package com.telefonia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonia.Entities.Estado;
import com.telefonia.persistence.IEstadoDAO;
import com.telefonia.service.IEstadoService;

@Service
public class EstadoServiceImpl implements IEstadoService{
    /*
     * Implementación de métodos de búsqueda
     */
    @Autowired
    private IEstadoDAO estadoDAO;

    @Override
    public List<Estado> findAll() {
        return estadoDAO.findAll();
    }

    @Override
    public Optional<Estado> findById(Byte clave) {
        return estadoDAO.findById(clave);
    }
    
}
