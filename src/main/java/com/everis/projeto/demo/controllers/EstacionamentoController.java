package com.everis.projeto.demo.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.everis.projeto.demo.controllers.dto.EstacionamentoDto;
import com.everis.projeto.demo.controllers.form.EstacionamentoForm;
import com.everis.projeto.demo.services.EstacionamentoService;

@RestController
@RequestMapping(value = "/estacionamento")
public class EstacionamentoController {
	
	@Autowired
	private EstacionamentoService estacionamentoService;

	
	@PostMapping
	@ResponseBody
	@Transactional
	public ResponseEntity<EstacionamentoDto> cadastrar(@RequestBody @Valid EstacionamentoForm EstacionamentoForm, UriComponentsBuilder uriBuilder) {
		return estacionamentoService.cadastrar(EstacionamentoForm, uriBuilder);
	}
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<EstacionamentoDto> buscar(@PathVariable Long id){
		
		return estacionamentoService.buscar(id);
	}
	
	@PutMapping(path = {"/{id}"})
	public ResponseEntity<EstacionamentoDto> atualizar(@PathVariable Long id, @Valid @RequestBody EstacionamentoForm estacionamentoForm){
		
		return estacionamentoService.atualizar(id, estacionamentoForm);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		
		return estacionamentoService.deletar(id);
	}
	
	@GetMapping
	public ResponseEntity<List<EstacionamentoDto>> listar(){
		return new ResponseEntity<List<EstacionamentoDto>>(estacionamentoService.listar(), HttpStatus.OK);
	}
}


