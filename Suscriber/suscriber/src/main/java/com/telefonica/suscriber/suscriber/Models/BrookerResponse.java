package com.telefonica.suscriber.suscriber.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrookerResponse {
    private String idSolicitud;
    private String estado;
    private String mensaje;
    private Object data;

    public BrookerResponse(String idSolicitud, String estado, String mensaje, Object data) {
        this.idSolicitud = idSolicitud;
        this.estado = estado;
        this.mensaje = mensaje;
        this.data = data;
    }

    
}
