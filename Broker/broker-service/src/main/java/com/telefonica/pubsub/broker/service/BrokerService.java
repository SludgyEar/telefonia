package com.telefonica.pubsub.broker.service;

// (3- Tercera clase editada )
// Es una interfaz, es decir, un contrato que define qué hace el servicio, pero no cómo lo hace.
// En otras palabras - 
// Aquí se definen los nombres de los métodos que el servicio debe tener, pero sin escribir el código dentro.

/*
No hace nada por sí solo, solo dice:
Habrá una función que procesa la petición del cliente.
Habrá otra que procesa la respuesta del publisher.
 */
import com.telefonica.pubsub.broker.dto.ClientRequestDTO;
import com.telefonica.pubsub.broker.dto.ClientResponseDTO;
import com.telefonica.pubsub.broker.dto.PublisherResponseDTO;

public interface  BrokerService {
	/*
	No hace nada por sí solo, solo nos dice -
	Habrá una función que procesa la petición del cliente.
	Habrá otra que procesa la respuesta del publisher.
	
	Aquí solo SE DEFINEN LOS MÉTODOS, sin escribir el cuerpo.
	Esto le dice a Java: "Cualquier clase que implemente esta INTERFAZ debe tener estos dos métodos".
	 */
	
	// SIGNIFICADO DE ESTÁS DECLARACIONES :
	/*
		Parte									Qué significa
	ClienteResponseDTO				Es el tipo de dato que devuelve el método (la respuesta que regresarás al
	 								Endpoint(controller) o al cliente).
	 								
	procesarPeticionCliente			Es el nombre del método, tú lo decides.
	
	(ClienteRequestDTO request)		Es el parámetro que recibe, en este caso, 
									un objeto con los datos que envía el cliente.
	 */
	
	ClientResponseDTO procesarPeticionCliente(ClientRequestDTO request);
	
	// Recibe una respuesta del publisher.
	// No devuelve nada (por eso void), solo actualiza datos en la base.
    void procesarRespuestaPublisher(PublisherResponseDTO response);
    

	

}
