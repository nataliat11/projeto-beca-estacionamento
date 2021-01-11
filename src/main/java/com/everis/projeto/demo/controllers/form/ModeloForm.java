package com.everis.projeto.demo.controllers.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.everis.projeto.demo.entities.Modelo;

public class ModeloForm {
	
	@NotNull @NotEmpty
	private String nome;

	public ModeloForm(){
	}
	
	public ModeloForm(Modelo modelo) {
		this.nome = modelo.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//	public Modelo converter(ModeloRepository modeloRepository) {
//		return new Modelo(nome);
//	}
	
	
	

}
