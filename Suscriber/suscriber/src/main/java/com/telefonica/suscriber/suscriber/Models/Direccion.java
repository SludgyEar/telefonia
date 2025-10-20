package com.telefonica.suscriber.suscriber.Models;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Direccion {
    private String id;
    private String nombre;
    private String asentamiento;
    private String cp;
    private String municipio;

    public Direccion(String id,String nombre, String asentamiento, String cp, String municipio) {
        this.id = id;
        this.nombre = nombre;
        this.asentamiento = asentamiento;
        this.cp = cp;
        this.municipio = municipio;
    }

    public String getIdSolicitud() {
        // TODO Auto-generated method stub
        return this.id;
    }

}
