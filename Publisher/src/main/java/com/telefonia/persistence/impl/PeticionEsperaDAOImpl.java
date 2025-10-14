package com.telefonia.persistence.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonia.Entities.PeticionEspera;
import com.telefonia.controllers.dto.CoberturaRequestDTO;
import com.telefonia.persistence.IPeticionEsperaDAO;
import com.telefonia.repository.PeticionEsperaRepository;

@Component
public class PeticionEsperaDAOImpl implements IPeticionEsperaDAO{
    @Autowired
    private PeticionEsperaRepository peticionEsperaRepository;

    @Override
    public void guardarPeticionSinCobertura(CoberturaRequestDTO request){
        PeticionEspera peticionEspera = PeticionEspera.builder()
            .ip(request.getIp())
            .codigoPostal(request.getDireccionDTO().getCodigoPostal())
            .colonia(request.getDireccionDTO().getColonia())
            .municipio(request.getDireccionDTO().getMunicipio())
            .estado(request.getDireccionDTO().getEstado())
            .idPeticion(request.getIdPeticion())
            .notificado(false)
            .fechaCreacion(LocalDateTime.now())
            .build();
        peticionEsperaRepository.save(peticionEspera);
    }
}
