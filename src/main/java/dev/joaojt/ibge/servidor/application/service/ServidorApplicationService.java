package dev.joaojt.ibge.servidor.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.joaojt.ibge.cliente.application.repository.ClienteRepository;
import dev.joaojt.ibge.servidor.application.api.ServidorEditaRequest;
import dev.joaojt.ibge.servidor.application.api.ServidorNovoRequest;
import dev.joaojt.ibge.servidor.application.api.ServidorResponse;
import dev.joaojt.ibge.servidor.application.repository.ServidorRepository;
import dev.joaojt.ibge.servidor.domain.Servidor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ServidorApplicationService implements ServidorService{
	
	private final ServidorRepository servidorRepository;
	private final ClienteRepository clienteRepository;
	
	@Override
	public void insereServidor(ServidorNovoRequest servidorNovo) {
		log.info("[inicia] ServidorApplicationService - insereServidor");
		Servidor servidor = new Servidor(servidorNovo);
		servidorRepository.salvaServidor(servidor);
		log.info("[finaliza] ServidorApplicationService - insereServidor");	
	}
	
	@Override
	public ServidorResponse buscaServidorPorId(Integer servidorId) {
		log.info("[inicia] ServidorApplicationService - buscaServidorPorId");
		Servidor servidor = servidorRepository.buscaServidorPorId(servidorId);
		log.info("[finaliza] ServidorApplicationService - buscaServidorPorId");	
		return new ServidorResponse(servidor);
	}
	
	@Override
	public List<ServidorResponse> buscaTodosServidor() {
		log.info("[inicia] ServidorApplicationService - buscaTodosServidor");
		List<Servidor> servidores = servidorRepository.buscaTodosServidor();
		log.info("[finaliza] ServidorApplicationService - buscaTodosServidor");	
		return ServidorResponse.converter(servidores);
	}
	
	@Override
	public void deletaServidor(Integer servidorId) {
		log.info("[inicia] ServidorApplicationService - deletaServidor");
	 	Servidor servidor = servidorRepository.buscaServidorPorId(servidorId);
	 	clienteRepository.buscaSeServidorEstaRelacionadoComCliente(servidorId);				
	 	servidorRepository.deletaServidor(servidor);
		log.info("[finaliza] ServidorApplicationService - deletaServidor");		
	}
	
	@Override
	public void editaServidor(Integer servidorId, ServidorEditaRequest servidorEdita) {
		log.info("[inicia] ServidorApplicationService - editaServidor");
		Servidor servidor = servidorRepository.buscaServidorPorId(servidorId);
		servidor.editaServidor(servidorEdita);
		servidorRepository.salvaServidor(servidor);
		log.info("[finaliza] ServidorApplicationService - editaServidor");		
	}
	
}