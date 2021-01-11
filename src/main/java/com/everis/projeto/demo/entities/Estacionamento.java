package com.everis.projeto.demo.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class Estacionamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	@Column(name = "entrada")
	private LocalDateTime dataEntrada;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	@Column(name = "saida")
	private LocalDateTime dataSaida;
	@Column(name = "valor_pago")
	private Double valorPago;

	
	@Column(name = "taxa_hora")
	private Double taxaHora;
	@Column(name = "duracao")
	public Double duracao;

	
	@ManyToOne
	@JoinColumn(name = "id_carro")
	private Carro carro;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}



	public Carro getCarro() {
		return carro;
	}

	public static boolean isPresent() {
		return true;
	}

	public Carro setCarro(Carro carro) {
		return carro;
		
	}


	public Double getTaxaHora() {
		return taxaHora;
	}

	public void setTaxaHora(Double taxaHora) {
		this.taxaHora = taxaHora;
	}

	public Double getDuracao() {
		return duracao;
	}

	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}


	
	

	
}