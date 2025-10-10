package com.telefonia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonia.Entities.Contrato;
import com.telefonia.persistence.IContratoDAO;
import com.telefonia.service.IContratoService;

@Service
public class ContratoServiceImpl implements IContratoService {

    @Autowired
    private IContratoDAO contratoDAO;

    @Override
    public List<Contrato> findAll() {
        return contratoDAO.findAll();
    }

    @Override
    public Optional<Contrato> findById(Short id) {
        return contratoDAO.findById(id);
    }
    
}