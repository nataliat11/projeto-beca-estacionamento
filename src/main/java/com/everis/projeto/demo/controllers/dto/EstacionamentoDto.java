package com.everis.projeto.demo.controllers.dto;

import java.time.LocalDateTime;

import com.everis.projeto.demo.entities.Estacionamento;

public class EstacionamentoDto {
	
	private Long id;
	private LocalDateTime entrada = LocalDateTime.now();
	private LocalDateTime saida = LocalDateTime.now();
	private Double valorPago;
	private CarroDto carro;
	
	public EstacionamentoDto(Estacionamento estacionamento) {
		this.id = estacionamento.getId();
		this.entrada = estacionamento.getDataEntrada();
		this.saida = estacionamento.getDataSaida();
		this.valorPago = estacionamento.getValorPago();
		this.carro = new CarroDto(estacionamento.getCarro());
	}
	
	
	public Long getId() {
		return id;
	}
	public LocalDateTime getEntrada() {
		return entrada;
	}
	public LocalDateTime getSaida() {
		return saida;
	}
	public Double getValorPago() {
		return valorPago;
	}

	public CarroDto getCarro() {
		return carro;
	}
	
	

	
	
}
