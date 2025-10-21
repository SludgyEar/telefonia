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
    /**
     * Se implementa la interfaz que recibe un request de cobertura, este request resultó en que
     * la dirección consultada no tiene cobertura, por lo cual se guarda la petición
     * para que pueda ser atendida después.
     * Por defecto se agrega la fecha de creación y un estado de NO NOTIFICADO
    */
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
