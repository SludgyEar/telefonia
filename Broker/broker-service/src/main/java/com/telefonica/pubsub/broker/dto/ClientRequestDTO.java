package com.telefonica.pubsub.broker.dto;

// REQUEST DE CLIENTES - JOSEPH

public class ClientRequestDTO {
	
	 private String idCliente;
	 public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getIpCliente() {
		return ipCliente;
	}
	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	private String ipCliente;
	 private String json;

}
