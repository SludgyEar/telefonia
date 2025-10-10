package com.telefonia.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonia.Entities.Estado;
import com.telefonia.persistence.IEstadoDAO;
import com.telefonia.repository.EstadoRepository;

@Component
public class EstadoDAOImpl implements IEstadoDAO{
    // Inyectamos el repositorio
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<Estado> findAll() {
        return (List<Estado>) estadoRepository.findAll();
    }

    @Override
    public Optional<Estado> findById(Byte clave) {
        return estadoRepository.findById(clave);
    }
    
}
