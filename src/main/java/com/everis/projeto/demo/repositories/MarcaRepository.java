package com.everis.projeto.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.everis.projeto.demo.entities.Marca;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Long>{

	Marca findById(long idModelo);

}
