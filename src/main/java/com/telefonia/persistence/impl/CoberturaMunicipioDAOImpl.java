package com.telefonia.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonia.Entities.CoberturaMunicipio;
import com.telefonia.persistence.ICoberturaMunicipioDAO;
import com.telefonia.repository.CoberturaMunicipioRepository;

@Component
public class CoberturaMunicipioDAOImpl implements ICoberturaMunicipioDAO {
    // Inyectamos el repositorio
    @Autowired
    private CoberturaMunicipioRepository coberturaMunicipioRepository;

    @Override
    public List<CoberturaMunicipio> findAll() {
        return (List<CoberturaMunicipio>) coberturaMunicipioRepository.findAll();
    }

    @Override
    public Optional<CoberturaMunicipio> findById(Short id) {
        return coberturaMunicipioRepository.findById(id);
    }
    
}