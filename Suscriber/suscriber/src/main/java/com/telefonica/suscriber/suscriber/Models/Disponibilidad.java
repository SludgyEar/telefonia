package com.telefonica.suscriber.suscriber.Models;

public class Disponibilidad
{
    private String idSolicitud;
    private String estado;
    private String mensaje;

    public Disponibilidad() {}

    public Disponibilidad(String idSolicitud, String estado, String mensaje) {
        this.idSolicitud = idSolicitud;
        this.estado = estado;
        this.mensaje = mensaje;
    }
}