package com.telefonica.suscriber.suscriber.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telefonica.suscriber.suscriber.Models.BrookerRequest;
import com.telefonica.suscriber.suscriber.Models.Coordenadas;
import com.telefonica.suscriber.suscriber.Models.Direccion;
import com.telefonica.suscriber.suscriber.Models.Disponibilidad;
import com.telefonica.suscriber.suscriber.Service.BrookerService;
import com.telefonica.suscriber.suscriber.Service.DisponibilidadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
public class DisponibilidadController {
    private final DisponibilidadService disponibilidadService;
    private final BrookerService brookerService;

    @Value("${brooker.url}")
    private String url;

    public DisponibilidadController(DisponibilidadService s, BrookerService b)
    {
        this.brookerService = b;
        this.disponibilidadService = s;
    }

    @PostMapping("/direccion")
    public String solicitarPorDireccion(@RequestBody Direccion request)
    {
        disponibilidadService.registrarSolicitud(request.getIdSolicitud());

        BrookerRequest br = new BrookerRequest(request.getIdSolicitud(), "direccion", request, url);
        brookerService.enviarAlBrooker(br);
        return request.getIdSolicitud();
    }

    @PostMapping("/coordenadas")
    public String solicitarPorDireccion(@RequestBody Coordenadas request)
    {
        disponibilidadService.registrarSolicitud(request.getIdSolicitud());

        BrookerRequest br = new BrookerRequest(request.getIdSolicitud(), "coordenadas", request, url);
        brookerService.enviarAlBrooker(br);
        return request.getIdSolicitud();
    }

    @GetMapping("/disponibilidad/{id}")
    public Disponibilidad verificar(@PathVariable String id) {
        return disponibilidadService.obtenerEstado(id);
    }
    
}
