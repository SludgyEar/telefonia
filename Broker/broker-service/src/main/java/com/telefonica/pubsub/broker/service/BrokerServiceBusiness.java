package com.telefonica.pubsub.broker.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;





//(4- Cuarta clase editada - 

/*
  Es la implementación de esa interfaz.
  Aquí se escribe  el código real que hace las operaciones de BROKER-SERVICE
  
   NOTA : Se llama “Impl” por “Implementation”.
*/

import com.telefonica.pubsub.broker.dto.*;
import com.telefonica.pubsub.broker.model.Peticion;

import com.telefonica.pubsub.broker.repository.PeticionRepository;

// La anotación @Service le dice a Spring Boot:
// “Registra esta clase como un servicio para que pueda ser usada en otros lugares”.
@Service
public class BrokerServiceBusiness implements BrokerService {
	
	@Autowired
    private PeticionRepository peticionRepository;
    private CurlPublisherService curlPublisherService;
    private CurlSubscriberService curlSubscriberService;
	
    // Crear una nueva petición
    @Override
    public ClientResponseDTO procesarPeticionCliente(ClientRequestDTO request) {
        Peticion peticion = new Peticion();
        peticion.setIdCliente(request.getIdCliente());
        peticion.setIpCliente(request.getIpCliente());
        peticion.setJsonData(request.getJson());
        peticion.setEstado("PENDIENTE");
        
        // Guardar en la base de datos
        peticionRepository.save(peticion);
        
        // Responder al cliente
        // return new ClienteResponseDTO("C001", "192.168.1.10", "Petición procesada");

        // curl endpoint marco para hacer la peticio y checar si tiene servicio 
        curlPublisherService.enviarCurl("ID",request.getJson());

        return new ClientResponseDTO(
                request.getIdCliente(),
                request.getIpCliente(),
                "Petición recibida y enviada al Publisher."
        );
    }

    @Override
    public void procesarRespuestaPublisher(PublisherResponseDTO response) {
        // Buscar la petición original
        Peticion peticion = peticionRepository.findById(response.getIdPeticion()).orElse(null);
        if (peticion != null) {
            peticion.setEstado("PROCESADO");
            peticionRepository.save(peticion);
        }
        // Curl a Leo(cliente) para que pueda ver el nuevo estatus de su request /consultas-pendientes/response
        curlSubscriberService.enviarCurl(response.getIdCliente().toString(), peticion.getJsonData());
    }


    // Endpoint para que el cliente mande la peticion que quiere verificar y ver si ya tiene actualizacion
    @Override
    public ClientResponseDTO consultarPeticion(ClientRequestDTO requestDTO) {
        /// Agregar curl para el endpoint del marco primero hacemos un select con idcliente 
        /// y ver si el estado sigue en pendiente prosigue sino se responde con lo que tiene la tabla
        /// /api/cobertura/consultar 
        Peticion peticion = peticionRepository.findById(requestDTO.getIdCliente()).orElse(null);
        if (peticion != null && peticion.getEstado() == "PENDIENTE")
        {
            curlPublisherService.enviarCurl(peticion.getIdPeticion().toString(),peticion.getJsonData());

            return new ClientResponseDTO(peticion.getIdCliente(), 
                peticion.getIpCliente(), 
                curlPublisherService.getResponseBody());
        }
        return new ClientResponseDTO(peticion.getIdCliente(), 
                peticion.getIpCliente(), 
                peticion.getEstado()); 
    }

}
