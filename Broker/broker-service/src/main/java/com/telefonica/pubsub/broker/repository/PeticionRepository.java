package com.telefonica.pubsub.broker.repository;

//(2- Segunda clase editada -  Interactúa con MySQL usando JPA. (findByIdPeticion(), save()) .)

import org.springframework.data.jpa.repository.JpaRepository;

import com.telefonica.pubsub.broker.model.Peticion;


public interface PeticionRepository extends JpaRepository<Peticion, Long> {

}
