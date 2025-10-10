package com.telefonia.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonia.Entities.Municipio;
import com.telefonia.persistence.IMunicipioDAO;
import com.telefonia.repository.MunicipioRepository;

@Component
public class MunicipioDAOImpl implements IMunicipioDAO{
    @Autowired
    private MunicipioRepository municipioRepository;

    @Override
    public List<Municipio> findAll() {
        return (List<Municipio>) municipioRepository.findAll();
    }

    @Override
    public Optional<Municipio> findById(Integer id) {
        return municipioRepository.findById(id);
    }
    
}
