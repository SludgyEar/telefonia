package com.telefonica.pubsub.broker.endpoint;
//(6 - Sexta clase editada -   MANEJO DE PETICIONES HTTP)

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.telefonica.pubsub.broker.dto.PublisherResponseDTO;
import com.telefonica.pubsub.broker.service.BrokerService;


@RestController
@RequestMapping("/publisher")
public class PublisherEndpoint {
	@Autowired
    private BrokerService brokerService;

    @PostMapping("/response")
    public void recibirRespuesta(@RequestBody PublisherResponseDTO response) {
        brokerService.procesarRespuestaPublisher(response);
    }
	

}
