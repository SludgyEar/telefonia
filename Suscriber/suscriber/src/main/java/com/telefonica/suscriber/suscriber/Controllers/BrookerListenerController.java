package com.telefonica.suscriber.suscriber.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telefonica.suscriber.suscriber.Models.BrookerResponse;
import com.telefonica.suscriber.suscriber.Service.DisponibilidadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/consultas-pendientes")
public class BrookerListenerController {
    private final DisponibilidadService disponibilidad;
    
    public BrookerListenerController(DisponibilidadService dC)
    {
        this.disponibilidad = dC;
    }

    @PostMapping("/response")
    public void recibirNotificacion(@RequestBody BrookerResponse respuesta) {
        disponibilidad.actualizarEstado(respuesta.getIdSolicitud(), respuesta.getEstado(), respuesta.getEstado());
    }
    
}
