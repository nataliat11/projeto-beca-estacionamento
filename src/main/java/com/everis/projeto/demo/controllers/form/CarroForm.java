package com.everis.projeto.demo.controllers.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.everis.projeto.demo.controllers.dto.MarcaDto;
import com.everis.projeto.demo.controllers.dto.ModeloDto;
import com.everis.projeto.demo.entities.Carro;


public class CarroForm {
	@NotNull @NotEmpty
	private  String placa;
	private  String cor;
	private  long idModelo;
	private  long idMarca;
	private ModeloDto modelo;
	private MarcaDto marca;
	
	public CarroForm() {
	}

	public CarroForm(Carro carro) {
		this.placa = carro.getPlaca();
		this.cor = carro.getCor();
	}

	public CarroForm(String placa, String cor, ModeloDto modelo,
			MarcaDto marca, Carro carro) {
		this.placa = placa;
		this.cor = cor;
		this.modelo = new ModeloDto(carro.getModelo());
		this.marca = new MarcaDto(carro.getMarca());
	}

	public  String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public  String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
	public long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(long idMarca) {
		this.idMarca = idMarca;
	}

	public long getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(long idModelo) {
		this.idModelo = idModelo;
	}

	public ModeloDto getModelo() {
		return modelo;
	}

	public void setModelo(ModeloDto modelo) {
		this.modelo = modelo;
	}

	public MarcaDto getMarca() {
		return marca;
	}

	public void setMarca(MarcaDto marca) {
		this.marca = marca;
	}

	

}
