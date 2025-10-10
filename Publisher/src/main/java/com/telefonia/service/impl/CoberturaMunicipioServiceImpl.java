package com.telefonia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonia.Entities.CoberturaMunicipio;
import com.telefonia.persistence.ICoberturaMunicipioDAO;
import com.telefonia.service.ICoberturaMunicipioService;

@Service
public class CoberturaMunicipioServiceImpl implements ICoberturaMunicipioService {

    @Autowired
    private ICoberturaMunicipioDAO coberturaMunicipioDAO;

    @Override
    public List<CoberturaMunicipio> findAll() {
        return coberturaMunicipioDAO.findAll();
    }

    @Override
    public Optional<CoberturaMunicipio> findById(Short id) {
        return coberturaMunicipioDAO.findById(id);
    }
    
}