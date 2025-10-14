package com.telefonia.persistence;

import org.springframework.stereotype.Repository;

import com.telefonia.controllers.dto.CoberturaRequestDTO;

@Repository
public interface IPeticionEsperaDAO {
    void guardarPeticionSinCobertura(CoberturaRequestDTO request);
}
