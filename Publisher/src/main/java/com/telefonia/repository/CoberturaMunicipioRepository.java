package com.telefonia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telefonia.Entities.CoberturaMunicipio;
@Repository
public interface CoberturaMunicipioRepository extends CrudRepository<CoberturaMunicipio, Integer>{
    

}
