package com.everis.projeto.demo.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.projeto.demo.entities.Estacionamento;

@Repository
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long>{
	
	List<Estacionamento> findByCarroPlaca(String placa);
	
	//public List<Estacionamento> findByDataSaidaBetween(LocalDateTime entrada, LocalDateTime saida);

	Estacionamento findByDataSaidaBetween(LocalDateTime dataEntrada, LocalDateTime dataSaida);


	

}
