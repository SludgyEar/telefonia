package com.telefonica.pubsub.broker.dto;


//REQUEST DE PUBLISHER - JOSEPH

public class PublisherRequestDTO {
	private String idPeticion;
    private String json;
    
	public String getIdPeticion() {
		return idPeticion;
	}
	public void setIdPeticion(String idPeticion) {
		this.idPeticion = idPeticion;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
    
}
