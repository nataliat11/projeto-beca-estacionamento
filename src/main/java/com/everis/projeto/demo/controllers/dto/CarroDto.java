package com.everis.projeto.demo.controllers.dto;

import com.everis.projeto.demo.entities.Carro;

public class CarroDto {
	
	private Long id;
	private String placa;
	private String cor;
	private ModeloDto modelo;
	private MarcaDto marca;
	
	public CarroDto() {
	}
	
	public CarroDto(Carro carro){
		this.id = carro.getId();
		this.placa = carro.getPlaca();
		this.cor = carro.getCor();
		this.modelo = new ModeloDto(carro.getModelo());
		this.marca = new MarcaDto(carro.getMarca());
		
	}
	
	public Long getId() {
		return id;
	}
	public String getPlaca() {
		return placa;
	}
	public String getCor() {
		return cor;
	}
	public ModeloDto getModelo() {
		return modelo;
	}
	public MarcaDto getMarca() {
		return marca;
	}


	

}
