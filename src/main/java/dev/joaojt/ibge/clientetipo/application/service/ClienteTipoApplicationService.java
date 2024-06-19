package dev.joaojt.ibge.clientetipo.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.joaojt.ibge.cliente.application.repository.ClienteRepository;
import dev.joaojt.ibge.clientetipo.application.api.ClienteTipoEditaRequest;
import dev.joaojt.ibge.clientetipo.application.api.ClienteTipoNovoRequest;
import dev.joaojt.ibge.clientetipo.application.api.ClienteTipoResponse;
import dev.joaojt.ibge.clientetipo.application.repository.ClienteTipoRepository;
import dev.joaojt.ibge.clientetipo.domain.ClienteTipo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ClienteTipoApplicationService implements ClienteTipoService{
	
	private final ClienteTipoRepository clienteTipoRepository;
	private final ClienteRepository clienteRepository;
	
	@Override
	public void insereClienteTipo(ClienteTipoNovoRequest clienteTipoNovo) {
		log.info("[inicia] ClienteTipoApplicationService - insereClienteTipo");
		ClienteTipo clienteTipo = new ClienteTipo(clienteTipoNovo);
		clienteTipoRepository.salvaClienteTipo(clienteTipo);
		log.info("[finaliza] ClienteTipoApplicationService - insereClienteTipo");	
	}

	@Override
	public void deletaClienteTipo(Integer clienteTipoId) {
		log.info("[inicia] ClienteTipoApplicationService - deletaClienteTipo");
	 	ClienteTipo clienteTipo = clienteTipoRepository.buscaClienteTipoPorId(clienteTipoId);
	 	clienteRepository.buscaSeClienteTipoEstaRelacionadoComCliente(clienteTipoId);				
		clienteTipoRepository.deletaClienteTipo(clienteTipo);
		log.info("[finaliza] ClienteTipoApplicationService - deletaClienteTipo");			
	}

	@Override
	public ClienteTipoResponse buscaClienteTipoPorId(Integer clienteTipoId) {
		log.info("[inicia] ClienteTipoApplicationService - buscaClienteTipoPorId");
		ClienteTipo clienteTipo = clienteTipoRepository.buscaClienteTipoPorId(clienteTipoId);
		log.info("[finaliza] ClienteTipoApplicationService - buscaClienteTipoPorId");			
		return new ClienteTipoResponse(clienteTipo);
	}

	@Override
	public List<ClienteTipoResponse> buscaTodosClienteTipo() {
		log.info("[inicia] ClienteTipoApplicationService - buscaTodosClienteTipo");
		List<ClienteTipo> clienteTipos = clienteTipoRepository.buscaTodosClienteTipo();
		log.info("[finaliza] ClienteTipoApplicationService - buscaTodosClienteTipo");			
		return ClienteTipoResponse.converter(clienteTipos);
	}

	@Override
	public void editaClienteTipo(Integer clienteTipoId, ClienteTipoEditaRequest clienteTipoEdita) {
		log.info("[inicia] ClienteTipoApplicationService - editaClienteTipo");
		ClienteTipo clienteTipo = clienteTipoRepository.buscaClienteTipoPorId(clienteTipoId);
		clienteTipo.editaClienteTipo(clienteTipoEdita);
		clienteTipoRepository.salvaClienteTipo(clienteTipo);
		log.info("[finaliza] ClienteTipoApplicationService - editaClienteTipo");			
	}
	
}