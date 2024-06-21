package dev.joaojt.ibge.cliente.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.joaojt.ibge.cliente.application.api.ClienteEditaRequest;
import dev.joaojt.ibge.cliente.application.api.ClienteNovoRequest;
import dev.joaojt.ibge.cliente.application.api.ClienteResponse;
import dev.joaojt.ibge.cliente.application.repository.ClienteRepository;
import dev.joaojt.ibge.cliente.domain.Cliente;
import dev.joaojt.ibge.clientetipo.application.repository.ClienteTipoRepository;
import dev.joaojt.ibge.clientetipo.domain.ClienteTipo;
import dev.joaojt.ibge.consorcio.application.repository.ConsorcioRepository;
import dev.joaojt.ibge.consorcio.domain.Consorcio;
import dev.joaojt.ibge.servidor.application.repository.ServidorRepository;
import dev.joaojt.ibge.servidor.domain.Servidor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService{
	
	private final ClienteRepository clienteRepository;
	private final ServidorRepository servidorRepository;
	private final ConsorcioRepository consorcioRepository;
	private final ClienteTipoRepository clienteTipoRepository;

	@Override
	public void insereCliente(ClienteNovoRequest clienteNovo) {
		log.info("[inicia] ClienteApplicationService - insereCliente");
		Servidor servidorPorta = clienteNovo.getIdServidorPorta() != null
				? servidorRepository.buscaServidorPorId(clienteNovo.getIdServidorPorta())
				: null;
		Servidor servidorBanco = clienteNovo.getIdServidorBanco() != null
				? servidorRepository.buscaServidorPorId(clienteNovo.getIdServidorBanco())
				: null;
		Consorcio consorcio = clienteNovo.getIdConsorcio() != null
				? consorcioRepository.buscaConsorcioPorId(clienteNovo.getIdConsorcio())
				: null;
		ClienteTipo clienteTipo = clienteNovo.getIdClienteTipo() != null
				? clienteTipoRepository.buscaClienteTipoPorId(clienteNovo.getIdClienteTipo())
				: null;
		Cliente cliente = new Cliente(clienteNovo, servidorPorta, servidorBanco, consorcio, clienteTipo);
		clienteRepository.salvaCliente(cliente);
		log.info("[finaliza] ClienteApplicationService - insereCliente");	
	}

	@Override
	public void deletaCliente(Integer clienteId) {
		log.info("[inicia] ClienteApplicationService - deletaCliente");
		Cliente cliente = clienteRepository.buscaClientePorId(clienteId);
		clienteRepository.deletaCliente(cliente);
		log.info("[finaliza] ClienteApplicationService - deletaCliente");		
	}

	@Override
	public ClienteResponse buscaClientePorId(Integer clienteId) {
		log.info("[inicia] ClienteApplicationService - buscaClientePorId");
		Cliente cliente = clienteRepository.buscaClientePorId(clienteId);
		log.info("[finaliza] ClienteApplicationService - buscaClientePorId");		
		return new ClienteResponse(cliente);
	}

	@Override
	public List<ClienteResponse> buscaTodosCliente() {
		log.info("[inicia] ClienteApplicationService - buscaTodosCliente");
		List<Cliente> clientes = clienteRepository.buscaTodosCliente();
		log.info("[finaliza] ClienteApplicationService - buscaTodosCliente");		
		return ClienteResponse.converter(clientes);
	}

	@Override
	public List<ClienteResponse> buscaClientesPorIbge(Integer clienteIbge) {
		log.info("[inicia] ClienteApplicationService - buscaClientesPorIbge");
		List<Cliente> clientes = clienteRepository.buscaClientesPorIbge(clienteIbge);
		log.info("[finaliza] ClienteApplicationService - buscaClientesPorIbge");		
		return ClienteResponse.converter(clientes);
	}

	@Override
	public List<ClienteResponse> buscaClientesPorDescricao(String clienteDescricao) {
		log.info("[inicia] ClienteApplicationService - buscaClientesPorDescricao");
		List<Cliente> clientes = clienteRepository.buscaClientesPorDescricao(clienteDescricao);
		log.info("[finaliza] ClienteApplicationService - buscaClientesPorDescricao");		
		return ClienteResponse.converter(clientes);
	}

	@Override
	public void editaCliente(Integer clienteId, ClienteEditaRequest clienteEdita) {
		log.info("[inicia] ClienteApplicationService - editaCliente");
		Servidor servidorPorta = clienteEdita.getIdServidorPorta() != null
				? servidorRepository.buscaServidorPorId(clienteEdita.getIdServidorPorta())
				: null;
		Servidor servidorBanco = clienteEdita.getIdServidorBanco() != null
				? servidorRepository.buscaServidorPorId(clienteEdita.getIdServidorBanco())
				: null;
		Consorcio consorcio = clienteEdita.getIdConsorcio() != null
				? consorcioRepository.buscaConsorcioPorId(clienteEdita.getIdConsorcio())
				: null;
		ClienteTipo clienteTipo = clienteEdita.getIdClienteTipo() != null
				? clienteTipoRepository.buscaClienteTipoPorId(clienteEdita.getIdClienteTipo())
				: null;
		Cliente cliente = new Cliente(clienteEdita, servidorPorta, servidorBanco, consorcio, clienteTipo);
		clienteRepository.salvaCliente(cliente);		
		log.info("[finaliza] ClienteApplicationService - editaCliente");				
	}
	
}