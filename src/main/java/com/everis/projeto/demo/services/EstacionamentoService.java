package com.everis.projeto.demo.services;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.everis.projeto.demo.controllers.dto.EstacionamentoDto;
import com.everis.projeto.demo.controllers.form.CarroForm;
import com.everis.projeto.demo.controllers.form.EstacionamentoForm;
import com.everis.projeto.demo.entities.Carro;
import com.everis.projeto.demo.entities.Estacionamento;
import com.everis.projeto.demo.repositories.CarroRepository;
import com.everis.projeto.demo.repositories.EstacionamentoRepository;
import com.everis.projeto.demo.repositories.MarcaRepository;
import com.everis.projeto.demo.repositories.ModeloRepository;

import javassist.NotFoundException;

@Service
public class EstacionamentoService {

	@Autowired
	private EstacionamentoRepository estacionamentoRepository;

	@Autowired
	private CarroRepository carroRepository;

	@Autowired
	private ModeloRepository modeloRepository;

	@Autowired
	private MarcaRepository marcaRepository;

	public ResponseEntity<EstacionamentoDto> cadastrar(@RequestBody @Valid EstacionamentoForm form,
			UriComponentsBuilder uriBuilder) {
		Estacionamento estacionamento = new Estacionamento();
		estacionamento.setDataEntrada(form.getEntrada());
		estacionamento.setDataSaida(form.getSaida());
		estacionamento.setValorPago(form.getValorPago());
		estacionamento.setCarro(form.getCarro());
		estacionamentoRepository.save(estacionamento);

		URI uri = uriBuilder.path("/estacionamentos/{id}").buildAndExpand(estacionamento.getId()).toUri();
		return ResponseEntity.created(uri).body(new EstacionamentoDto(estacionamento));

	}

	public ResponseEntity<EstacionamentoDto> buscar(Long id) {
		Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(id);

		if (estacionamento.isPresent()) {
			return ResponseEntity.ok(new EstacionamentoDto(estacionamento.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	public ResponseEntity<EstacionamentoDto> atualizar(Long id, @Valid EstacionamentoForm form) {
		Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(id);

		if (estacionamento.isPresent()) {
			estacionamento.get().setDataEntrada(form.getEntrada());
			estacionamento.get().setDataSaida(form.getSaida());
			estacionamento.get().setValorPago(form.getValorPago());
			estacionamento.get().setCarro(form.getCarro());
			estacionamentoRepository.save(estacionamento.get());
			return ResponseEntity.ok(new EstacionamentoDto(estacionamento.get()));

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	public ResponseEntity<?> deletar(Long id) {
		Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(id);

		if (estacionamento.isPresent()) {
			estacionamentoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@Transactional
	public ResponseEntity<EstacionamentoDto> entrada(CarroForm carroForm, UriComponentsBuilder uriBuilder)
			throws NotFoundException {

		Carro carro = carroRepository.findByPlaca(carroForm.getPlaca());

		if (carro == null) {
			carro = new Carro();
			carro.setPlaca(carro.getPlaca());
			carro.setCor(carro.getCor());

			if (modeloRepository.findById(carroForm.getIdModelo()) != null) {
				carro.setModelo(modeloRepository.findById(carroForm.getIdModelo()));
			}
			if (marcaRepository.findById(carroForm.getIdMarca()) != null) {
				carro.setMarca(marcaRepository.findById(carroForm.getIdMarca()));
			}

			carroRepository.save(carro);
		}

		Estacionamento estacionamento = new Estacionamento();
		estacionamento.setDataEntrada(LocalDateTime.now());
		estacionamento.setCarro(carro);
		estacionamentoRepository.save(estacionamento);

		URI uri = uriBuilder.path("/estacionamento/{id}").buildAndExpand(estacionamento.getId()).toUri();

		return ResponseEntity.created(uri).body(new EstacionamentoDto(estacionamento));
	}

	@Transactional
	public ResponseEntity<EstacionamentoDto> entrada(EstacionamentoForm estacionamentoForm, UriComponentsBuilder uriBuilder) {

		Estacionamento estacionamento = estacionamentoRepository
				.findByDataSaidaBetween(estacionamentoForm.getEntrada(), estacionamentoForm.getSaida());
		
		estacionamentoRepository.save(estacionamento);

		URI uri = uriBuilder.path("/estacionamento/{id}").buildAndExpand(estacionamento.getId()).toUri();

		return ResponseEntity.created(uri).body(new EstacionamentoDto(estacionamento));

	}



	@Transactional
	public ResponseEntity<EstacionamentoDto> saida(@RequestBody @Valid CarroForm carroForm,
			UriComponentsBuilder uriBuilder) throws NotFoundException {
		Carro carro = carroRepository.findByPlaca(carroForm.getPlaca());

		if (carro == null) {
			throw new NotFoundException("Carro não localizado");
		}

		Estacionamento estacionamento = estacionamentoRepository.findByDataSaidaBetween(null, null);

		if (estacionamento == null) {
			throw new NotFoundException("Movimentação não encotrada!");
		}

		estacionamento.setDataSaida(LocalDateTime.now());

		Double duracao = Double
				.valueOf(estacionamento.getDataEntrada().until(estacionamento.getDataSaida(), ChronoUnit.HOURS));

		if (duracao == 0) {
			duracao = 1.0;
		}
		estacionamento.setValorPago(duracao);

		if (estacionamento.getDuracao() < -1) {
			estacionamento.setValorPago(Double.valueOf(5));
		} else {
			Double valorPago = 5.0;
			Double tempo = estacionamento.getDuracao();
			tempo = tempo - 1;
			while (tempo > 0) {
				valorPago = valorPago + 2;
				tempo = tempo - 1;
			}
		}

		estacionamentoRepository.save(estacionamento);

		URI uri = uriBuilder.path("/estacionamento/{id}").buildAndExpand(estacionamento.getId()).toUri();

		return ResponseEntity.created(uri).body(new EstacionamentoDto(estacionamento));

	}

	public List<EstacionamentoDto> findAll(List<EstacionamentoDto> estacionamento) {
		return estacionamento;
	}

	public List<EstacionamentoDto> buscar(List<EstacionamentoDto> estacionamento) {
		return estacionamento;
	}
	
	public List<EstacionamentoDto> listar() {
		List<Estacionamento> lista = estacionamentoRepository.findAll();
		List<EstacionamentoDto> listaDto = new ArrayList<>();
		lista.forEach(estacionamento -> {listaDto.add(new EstacionamentoDto(estacionamento));});
		return listaDto;
	}

}
