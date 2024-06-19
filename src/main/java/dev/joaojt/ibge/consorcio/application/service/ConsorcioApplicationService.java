package dev.joaojt.ibge.consorcio.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.joaojt.ibge.cliente.application.repository.ClienteRepository;
import dev.joaojt.ibge.consorcio.application.api.ConsorcioEditaRequest;
import dev.joaojt.ibge.consorcio.application.api.ConsorcioNovoRequest;
import dev.joaojt.ibge.consorcio.application.api.ConsorcioResponse;
import dev.joaojt.ibge.consorcio.application.repository.ConsorcioRepository;
import dev.joaojt.ibge.consorcio.domain.Consorcio;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ConsorcioApplicationService implements ConsorcioService{
	
	private final ConsorcioRepository consorcioRepository;
	private final ClienteRepository clienteRepository;

	@Override
	public void insereConsorcio(ConsorcioNovoRequest consorcioNovo) {
		log.info("[inicia] ConsorcioApplicationService - insereConsorcio");
		Consorcio consorcio = new Consorcio(consorcioNovo);
		consorcioRepository.salvaConsorcio(consorcio);
		log.info("[finaliza] ConsorcioApplicationService - insereConsorcio");			
	}

	@Override
	public void deletaConsorcio(Integer consorcioId) {
		log.info("[inicia] ConsorcioApplicationService - deletaConsorcio");
	 	Consorcio consorcio = consorcioRepository.buscaConsorcioPorId(consorcioId);
	 	clienteRepository.buscaSeConsorcioEstaRelacionadoComCliente(consorcioId);				
	 	consorcioRepository.deletaConsorcio(consorcio);
		log.info("[finaliza] ConsorcioApplicationService - deletaConsorcio");			
	}

	@Override
	public void editaConsorcio(Integer consorcioId, ConsorcioEditaRequest consorcioEdita) {
		log.info("[inicia] ConsorcioApplicationService - editaConsorcio");
		Consorcio consorcio = consorcioRepository.buscaConsorcioPorId(consorcioId);
		consorcio.editaConsorcio(consorcioEdita);
		consorcioRepository.salvaConsorcio(consorcio);
		log.info("[finaliza] ConsorcioApplicationService - editaConsorcio");		
	}

	@Override
	public ConsorcioResponse buscaConsorcioPorId(Integer consorcioId) {
		log.info("[inicia] ConsorcioApplicationService - buscaConsorcioPorId");
		Consorcio consorcio = consorcioRepository.buscaConsorcioPorId(consorcioId);
		log.info("[finaliza] ConsorcioApplicationService - buscaConsorcioPorId");		
		return new ConsorcioResponse(consorcio);
	}

	@Override
	public List<ConsorcioResponse> buscaTodosConsorcio() {
		log.info("[inicia] ConsorcioApplicationService - buscaTodosConsorcio");
		List<Consorcio> consorcios = consorcioRepository.buscaTodosConsorcio();
		log.info("[finaliza] ConsorcioApplicationService - buscaTodosConsorcio");			
		return ConsorcioResponse.converter(consorcios);
	}
	
}