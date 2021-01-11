package com.everis.projeto.demo.services;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.everis.projeto.demo.controllers.dto.CarroDto;
import com.everis.projeto.demo.controllers.form.CarroForm;
import com.everis.projeto.demo.entities.Carro;
import com.everis.projeto.demo.repositories.CarroRepository;
import com.everis.projeto.demo.repositories.MarcaRepository;
import com.everis.projeto.demo.repositories.ModeloRepository;

@Service
public class CarroService {
	
	@Autowired
	private  CarroRepository carroRepository;
	
	@Autowired
	private  ModeloRepository modeloRepository;
	
	@Autowired
	private  MarcaRepository marcaRepository;
	
	public ResponseEntity<CarroDto>cadastrar(@RequestBody @Valid CarroForm form, UriComponentsBuilder uriBuilder) {
		Carro carro = new Carro();
		carro.setPlaca(form.getPlaca());
		carro.setCor(form.getCor());
		
		carro.setModelo(modeloRepository.findById(form.getIdModelo()));
		carro.setMarca(marcaRepository.findById(form.getIdMarca()));

		carroRepository.save(carro);
		
		URI uri = uriBuilder.path("/carros/{id}").buildAndExpand(carro.getId()).toUri();
		return ResponseEntity.created(uri).body(new CarroDto(carro));
		
	}


	
	public ResponseEntity<CarroDto> buscar(Long id) {
		Optional<Carro> carro = carroRepository.findById(id);
		
		if(carro.isPresent()) {
			
			return ResponseEntity.ok(new CarroDto(carro.get()));
		}
		
		return ResponseEntity.notFound().build();
		
	}

	public ResponseEntity<CarroDto> atualizar(Long id, @Valid CarroForm carroForm) {
		Optional<Carro> carro = carroRepository.findById(id);
			
		if(carro.isPresent()) {
			carro.get().setPlaca(carroForm.getPlaca());
			carro.get().setCor(carroForm.getCor());
			return ResponseEntity.ok(new CarroDto(carro.get()));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}


	public ResponseEntity<?> deletar(Long id) {
		Optional<Carro> carro = carroRepository.findById(id);
		
		if(carro.isPresent()) {
			carroRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	
	


}
