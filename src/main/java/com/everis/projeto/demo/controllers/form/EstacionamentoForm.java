package com.everis.projeto.demo.controllers.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.everis.projeto.demo.entities.Carro;
import com.everis.projeto.demo.entities.Estacionamento;
import com.fasterxml.jackson.annotation.JsonFormat;

public class EstacionamentoForm {
	
	@NotNull @NotEmpty
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private  LocalDateTime entrada = LocalDateTime.now();
	@NotNull @NotEmpty
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private  LocalDateTime saida = LocalDateTime.now();
	private  Double valorPago;
	private  Carro carro;
	private Double taxaHora;
	
	
	public EstacionamentoForm(Estacionamento estacionamento) {
		this.entrada = estacionamento.getDataEntrada();
		this.saida = estacionamento.getDataSaida();
		this.valorPago = estacionamento.getValorPago();
		this.taxaHora = estacionamento.getTaxaHora();
	}
	
	public  LocalDateTime getEntrada() {
		return entrada;
	}
	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}
	public  LocalDateTime getSaida() {
		return saida;
	}
	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}
	public  Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	public  Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}


	public Double getTaxaHora() {
		return taxaHora;
	}

	public void setTaxaHora(Double taxaHora) {
		this.taxaHora = taxaHora;
	}

	public String getCarro(String placa) {
		return placa;
	}


	
}
