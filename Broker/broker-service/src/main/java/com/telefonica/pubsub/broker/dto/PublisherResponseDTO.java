package com.telefonica.pubsub.broker.dto;

public class PublisherResponseDTO {
	
	 private Long idPeticion;
	 private Long idCliente;
	 private String ipCliente;
	 private String respuesta;
	 
	public Long  getIdPeticion() {
		return idPeticion;
	}
	public void setIdPeticion(Long  idPeticion) {
		this.idPeticion = idPeticion;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getIpCliente() {
		return ipCliente;
	}
	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

}
