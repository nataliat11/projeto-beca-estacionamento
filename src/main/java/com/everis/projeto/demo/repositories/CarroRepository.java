package com.everis.projeto.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.everis.projeto.demo.entities.Carro;

@Repository
public interface CarroRepository extends CrudRepository<Carro, Long>{

	 Carro findByPlaca(String placa);
	
}
