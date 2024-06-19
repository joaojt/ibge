package dev.joaojt.ibge.cliente.application.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import dev.joaojt.ibge.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI{
	
	private final ClienteService clienteService;

	@Override
	public void insereCliente(ClienteNovoRequest clienteNovo) {
		log.info("[inicia] ClienteController - insereCliente");
		clienteService.insereCliente(clienteNovo);
		log.info("[finaliza] ClienteController - insereCliente");		
	}

	@Override
	public void deletaCliente(Integer clienteId) {
		log.info("[inicia] ClienteController - deletaCliente");
		// TODO Auto-generated method stub
		log.info("[finaliza] ClienteController - deletaCliente");
	}

	@Override
	public ClienteResponse buscaClientePorId(Integer clienteId) {
		log.info("[inicia] ClienteController - buscaClientePorId");
		// TODO Auto-generated method stub
		log.info("[finaliza] ClienteController - buscaClientePorId");
		return null;
	}

	@Override
	public List<ClienteResponse> buscaTodosCliente() {
		log.info("[inicia] ClienteController - buscaTodosClientes");
		// TODO Auto-generated method stub
		log.info("[finaliza] ClienteController - buscaTodosClientes");
		return null;
	}

	@Override
	public List<ClienteResponse> buscaClientesPorIbge(Integer clienteIbge) {
		log.info("[inicia] ClienteController - buscaClientesPorIbge");
		// TODO Auto-generated method stub
		log.info("[finaliza] ClienteController - buscaClientesPorIbge");
		return null;
	}

	@Override
	public List<ClienteResponse> buscaClientesPorDescricao(String clienteDescricao) {
		log.info("[inicia] ClienteController - buscaClientesPorDescricao");
		// TODO Auto-generated method stub
		log.info("[finaliza] ClienteController - buscaClientesPorDescricao");
		return null;
	}

	@Override
	public void editaCliente(Integer clienteId, ClienteEditaRequest clienteEdita) {
		log.info("[inicia] ClienteController - editaCliente");
		// TODO Auto-generated method stub
		log.info("[finaliza] ClienteController - editaCliente");
	}

}