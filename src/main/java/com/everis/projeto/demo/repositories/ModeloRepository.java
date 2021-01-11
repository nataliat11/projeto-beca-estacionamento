package com.everis.projeto.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.everis.projeto.demo.entities.Modelo;

@Repository
public interface ModeloRepository extends CrudRepository<Modelo, Long> {

	Modelo findById(long idModelo);

	

}
