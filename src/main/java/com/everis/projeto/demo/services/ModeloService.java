package com.everis.projeto.demo.services;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.everis.projeto.demo.controllers.dto.ModeloDto;
import com.everis.projeto.demo.controllers.form.ModeloForm;
import com.everis.projeto.demo.entities.Modelo;
import com.everis.projeto.demo.repositories.ModeloRepository;

@Service
public class ModeloService {
	
	@Autowired
	private  ModeloRepository modeloRepository;
	
	public ResponseEntity<ModeloDto>cadastrar(@RequestBody @Valid ModeloForm form, UriComponentsBuilder uriBuilder) {
		Modelo modelo = new Modelo();
		modelo.setNome(form.getNome());
		modeloRepository.save(modelo);
		
		URI uri = uriBuilder.path("/modelos/{id}").buildAndExpand(modelo.getId()).toUri();
		return ResponseEntity.created(uri).body(new ModeloDto(modelo));
		
	}


	
	public ResponseEntity<ModeloDto> buscar(Long id) {
		Optional<Modelo> modelo = modeloRepository.findById(id);
		
		if(modelo.isPresent()) {
			
			return ResponseEntity.ok(new ModeloDto(modelo.get()));
		}
		
		return ResponseEntity.notFound().build();
		
	}

	public ResponseEntity<ModeloDto> atualizar(Long id, @Valid ModeloForm modeloForm) {
		Optional<Modelo> modelo = modeloRepository.findById(id);
			
		if(modelo.isPresent()) {
			modelo.get().setNome(modeloForm.getNome());
			return ResponseEntity.ok(new ModeloDto(modelo.get()));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}


	public ResponseEntity<?> deletar(Long id) {
		Optional<Modelo> modelo = modeloRepository.findById(id);
		
		if(modelo.isPresent()) {
			modeloRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	


}