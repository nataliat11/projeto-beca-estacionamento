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

import com.everis.projeto.demo.controllers.dto.MarcaDto;
import com.everis.projeto.demo.controllers.form.MarcaForm;
import com.everis.projeto.demo.services.MarcaService;

@RestController
@RequestMapping(value = "/marca")
public class MarcaController{
	
	
	@Autowired
	private MarcaService marcaService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<MarcaDto> cadastrar(@RequestBody @Valid MarcaForm MarcaForm, UriComponentsBuilder uriBuilder) {
		return marcaService.cadastrar(MarcaForm, uriBuilder);
	}
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<MarcaDto> buscar(@PathVariable Long id){
		
		return marcaService.buscar(id);
	}
	
	@PutMapping(path = {"/{id}"})
	public ResponseEntity<MarcaDto> atualizar(@PathVariable Long id, @Valid @RequestBody MarcaForm marcaForm){
		
		return marcaService.atualizar(id, marcaForm);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		
		return marcaService.deletar(id);
	}
	
	
	
	
	
	
	
}