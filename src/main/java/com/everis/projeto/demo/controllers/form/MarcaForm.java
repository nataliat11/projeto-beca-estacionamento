package com.everis.projeto.demo.controllers.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.everis.projeto.demo.entities.Marca;

public class MarcaForm {
	
	@NotNull @NotEmpty
	private String nome;
	
	public MarcaForm() {
	}
	
	public MarcaForm(Marca marca) {
		this.nome = marca.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//	public Marca converter(MarcaRepository modeloRepository) {
//		return new Marca(nome);
//	}
	


}
