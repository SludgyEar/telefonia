package com.telefonica.suscriber.suscriber.Models;
import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BrookerRequest {
    private String idCliente;
    @Value("${ip.cliente}")
    private String ipCliente;
    private Object payload;
    private String callbackURL;

    public BrookerRequest(String idSolicitud, Object payload, String callbackURL) {
        this.idCliente = idSolicitud;
        this.payload = payload;
        this.callbackURL = callbackURL;
    }
    
}
