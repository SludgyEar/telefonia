package com.telefonica.suscriber.suscriber.Service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.telefonica.suscriber.suscriber.Models.Disponibilidad;

@Service
public class DisponibilidadService {
    private final FileStorageService storageService;
    private final ConcurrentHashMap<String, Disponibilidad> solicitudes;
    
    public DisponibilidadService(FileStorageService storageService) {
        this.storageService = storageService;
        this.solicitudes = new ConcurrentHashMap<>();
    }

    public synchronized void registrarSolicitud(String id)
    {
        solicitudes.put(id, new Disponibilidad( id, "PENDIENTE", "Solicitud en proceso"));
        storageService.guardarSolicitudes(solicitudes);
    }

    public synchronized void actualizarEstado(String id, String estado, String mensaje)
    {
        solicitudes.put(id, new Disponibilidad( id, estado, mensaje));
        storageService.guardarSolicitudes(solicitudes);
    }

    public synchronized Disponibilidad obtenerEstado(String id)
    {
        return solicitudes.getOrDefault(id,new Disponibilidad(id,"No encontrada", "La solicitud no existe"));
    }
}
