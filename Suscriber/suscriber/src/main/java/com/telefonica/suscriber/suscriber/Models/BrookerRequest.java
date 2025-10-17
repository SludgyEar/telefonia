package com.telefonica.suscriber.suscriber.Models;


public class BrookerRequest {
    private String idSolicitud;
    private String tipo;
    private Object payload;
    private String callbackURL;

    public BrookerRequest(String idSolicitud, String tipo, Object payload, String callbackURL) {
        this.idSolicitud = idSolicitud;
        this.tipo = tipo;
        this.payload = payload;
        this.callbackURL = callbackURL;
    }
    
}
