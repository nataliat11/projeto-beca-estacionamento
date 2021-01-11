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

import com.everis.projeto.demo.controllers.dto.CarroDto;
import com.everis.projeto.demo.controllers.form.CarroForm;
import com.everis.projeto.demo.services.CarroService;

@RestController
@RequestMapping(value = "/carros")
public class CarroController {
	@Autowired
	private CarroService carroService;

	@PostMapping
	@Transactional
	public ResponseEntity<CarroDto> cadastrar(@RequestBody @Valid CarroForm CarroForm, UriComponentsBuilder uriBuilder) {
		return carroService.cadastrar(CarroForm, uriBuilder);
	}
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<CarroDto> buscar(@PathVariable Long id){
		
		return carroService.buscar(id);
	}
	
	@PutMapping(path = {"/{id}"})
	public ResponseEntity<CarroDto> atualizar(@PathVariable Long id, @Valid @RequestBody CarroForm carroForm){
		
		return carroService.atualizar(id, carroForm);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		
		return carroService.deletar(id);
	}
	
}

