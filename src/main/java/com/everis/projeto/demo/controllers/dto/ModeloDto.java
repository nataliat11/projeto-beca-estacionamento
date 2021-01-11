package com.everis.projeto.demo.controllers.dto;

import com.everis.projeto.demo.entities.Modelo;

public class ModeloDto {
	
	private Long id;
	private String nome;
	
	
	public ModeloDto(Modelo modelo) {
		if(modelo!= null) {
			this.id = modelo.getId();
			this.nome = modelo.getNome();
		}
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return nome;
	}
	
//	public static List<ModeloDto> converter(List<Modelo> modelo) {
//		return modelo.stream().map(ModeloDto::new).collect(Collectors.toList());
//	}


}
