package com.telefonica.pubsub.broker.endpoint;
//(5- Quinta clase editada -   MANEJO DE PETICIONES HTTP DEL PARTE DEL CLIENTE)


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.telefonica.pubsub.broker.dto.*;
import com.telefonica.pubsub.broker.service.BrokerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/cliente")

public class ClientEndpoint {
	/*
	 Spring inyecta automáticamente (@Autowired) una instancia del BrokerServiceImpl dentro del controller.
	 */
	@Autowired
	private BrokerService brokerService;
	@PostMapping("/request")
	public ClientResponseDTO recibirPeticion(@RequestBody ClientRequestDTO request) {
		//Entonces cuando el endpoint(controller) llama a :
	    return brokerService.procesarPeticionCliente(request);
	    
	    /*
	     BrokerServiceImpl hace la lógica:
		1. Valida los datos.
		2. Guarda la información en la base de datos.
		3. Devuelve una respuesta al controller (y este al cliente).
	     */
	}

	@PostMapping("/consulta/{id}")
	public ClientResponseDTO consultarPeticion(@RequestBody ClientRequestDTO request)
	{
		return brokerService.consultarPeticion(request);
	}

		

}
