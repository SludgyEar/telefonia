package com.telefonica.pubsub.broker.model;
// (1- Primera clase editada -  Representara la tabla en la base de datos.)

import jakarta.persistence.*;

@Entity
@Table(name = "peticion")
public class Peticion {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeticion;

    private String idCliente;
    private String ipCliente;

    @Lob
    private String jsonData;

    private String estado; // PENDIENTE / PROCESADO

    public Long getIdPeticion() { return idPeticion; }
    public void setIdPeticion(Long idPeticion) { this.idPeticion = idPeticion; }

    public String getIdCliente() { return idCliente; }
    public void setIdCliente(String idCliente) { this.idCliente = idCliente; }

    public String getIpCliente() { return ipCliente; }
    public void setIpCliente(String ipCliente) { this.ipCliente = ipCliente; }

    public String getJsonData() { return jsonData; }
    public void setJsonData(String jsonData) { this.jsonData = jsonData; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
	

}
