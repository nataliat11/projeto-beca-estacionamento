package com.everis.projeto.demo.services;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.everis.projeto.demo.controllers.dto.MarcaDto;
import com.everis.projeto.demo.controllers.form.MarcaForm;
import com.everis.projeto.demo.entities.Marca;
import com.everis.projeto.demo.repositories.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private  MarcaRepository marcaRepository;
	
	public ResponseEntity<MarcaDto>cadastrar(@RequestBody @Valid MarcaForm form, UriComponentsBuilder uriBuilder) {
		Marca marca = new Marca();
		marca.setNome(form.getNome());
		marcaRepository.save(marca);
		
		URI uri = uriBuilder.path("/marcas/{id}").buildAndExpand(marca.getId()).toUri();
		return ResponseEntity.created(uri).body(new MarcaDto(marca));
		
	}


	
	public ResponseEntity<MarcaDto> buscar(Long id) {
		Optional<Marca> marca = marcaRepository.findById(id);
		
		if(marca.isPresent()) {
			
			return ResponseEntity.ok(new MarcaDto(marca.get()));
		}
		
		return ResponseEntity.notFound().build();
		
	}

	public ResponseEntity<MarcaDto> atualizar(Long id, @Valid MarcaForm marcaForm) {
		Optional<Marca> marca = marcaRepository.findById(id);
			
		if(marca.isPresent()) {
			marca.get().setNome(marcaForm.getNome());
			return ResponseEntity.ok(new MarcaDto(marca.get()));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}


	public ResponseEntity<?> deletar(Long id) {
		Optional<Marca> marca = marcaRepository.findById(id);
		
		if(marca.isPresent()) {
			marcaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	


}