package com.everis.projeto.demo.controllers.dto;

import com.everis.projeto.demo.entities.Marca;

public class MarcaDto {
	
	private Long id;
	private String nome;
	
	public MarcaDto(Marca marca) {
		if(marca != null) {
		this.id = marca.getId();
		this.nome = marca.getNome();
		}
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
//	public static List<MarcaDto> converter(List<Marca> marca) {
//		return marca.stream().map(MarcaDto::new).collect(Collectors.toList());
//	}

	
	
	

}
