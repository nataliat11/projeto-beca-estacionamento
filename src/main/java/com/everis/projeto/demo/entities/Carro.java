package com.everis.projeto.demo.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Carro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "placa")
	private String placa;
	@Column(name = "cor")
	private String cor;
	
	
	@ManyToOne
	@JoinColumn(name = "id_modelo")
	private Modelo modelo;
	
	@ManyToOne
	@JoinColumn(name = "id_marca")
	private Marca marca;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Modelo getClass(Modelo modelo) {
		return modelo;
	}

	public Marca getClass(Marca marca) {
		return marca;
	}


	public static boolean isPresent() {
		return true;
	}

	public Marca getMarca() {
		return marca;
	}

	public Modelo getModelo() {
		return modelo;
	}



}
