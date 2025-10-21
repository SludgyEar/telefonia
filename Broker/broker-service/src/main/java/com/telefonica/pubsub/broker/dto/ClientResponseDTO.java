package com.telefonica.pubsub.broker.dto;

public class ClientResponseDTO {
	 private Long idCliente;
	 private String ipCliente;
	 private String mensaje;
	 
	 public ClientResponseDTO(Long idCliente, String ipCliente, String mensaje) {
	        this.idCliente = idCliente;
	        this.ipCliente = ipCliente;
	        this.mensaje = mensaje;
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
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	 
	 

}
