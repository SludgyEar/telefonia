package com.telefonica.suscriber.suscriber.Models;

public class Coordenadas {
    private String id;
    private double latitud;
    private double longitud;

    public Coordenadas(String id,double latitud, double laongitud)
    {
        this.id = id;
        this.latitud = latitud;
        this.longitud = laongitud;
    }

    public String getIdSolicitud() {
        return this.id;
    }
}

