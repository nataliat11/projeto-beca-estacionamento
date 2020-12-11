package com.everis.projeto.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.projeto.demo.entities.Carro;
import com.everis.projeto.demo.entities.Marca;
import com.everis.projeto.demo.entities.Modelo;

@RestController
@RequestMapping(value = "/carros")
public class CarroResource {
	
	@GetMapping
	public ResponseEntity<Carro> findAll(){
		Modelo mod = new Modelo(1L, "GOL");
		Marca mar = new Marca(1L, "FIAT");
		Carro car = new Carro(1L, "JMB-0329", "PRETO", mod, mar);
		return ResponseEntity.ok().body(car);
	}
	
	
}
