package com.everis.projeto.demo.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.everis.projeto.demo.controllers.dto.ModeloDto;
import com.everis.projeto.demo.controllers.form.ModeloForm;
import com.everis.projeto.demo.services.ModeloService;

@RestController
@RequestMapping(value = "/modelo")
public class ModeloController{
	
	@Autowired
	private ModeloService modeloService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<ModeloDto> cadastrar(@RequestBody @Valid ModeloForm ModeloForm, UriComponentsBuilder uriBuilder) {
		return modeloService.cadastrar(ModeloForm, uriBuilder);
	}
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<ModeloDto> buscar(@PathVariable Long id){
		
		return modeloService.buscar(id);
	}
	
	@PutMapping(path = {"/{id}"})
	public ResponseEntity<ModeloDto> atualizar(@PathVariable Long id, @Valid @RequestBody ModeloForm modeloForm){
		
		return modeloService.atualizar(id, modeloForm);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		
		return modeloService.deletar(id);
	}
	
	
	
	
}
