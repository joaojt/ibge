package dev.joaojt.ibge.cliente.application.service;

import org.springframework.stereotype.Service;

import dev.joaojt.ibge.cliente.application.api.ClienteNovoRequest;
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
	
}