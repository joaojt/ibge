package dev.joaojt.ibge.cliente.infra;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import dev.joaojt.ibge.cliente.application.repository.ClienteRepository;
import dev.joaojt.ibge.cliente.domain.Cliente;
import dev.joaojt.ibge.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
@RequiredArgsConstructor
public class ClienteRepositoryDB implements ClienteRepository{
	
	private final ClienteRepositoryJpa clienteRepositoryJpa;

	@Override
	public void salvaCliente(Cliente cliente) {
		log.info("[inicia] ClienteRepositoryDB - salvaCliente");
		clienteRepositoryJpa.save(cliente);
		log.info("[finaliza] ClienteRepositoryDB - salvaCliente");
	}

	@Override
	public void buscaSeClienteTipoEstaRelacionadoComCliente(Integer clienteTipoId) {
		log.info("[inicia] ClienteRepositoryDB - buscaSeClienteTipoEstaRelacionadoComCliente");
		if (clienteRepositoryJpa.findFirstByClienteTipoId(clienteTipoId).isPresent()) {
			log.info("[finaliza] ClienteRepositoryDB - buscaSeClienteTipoEstaRelacionadoComCliente");
			throw APIException.build(HttpStatus.BAD_REQUEST,
					"Existe(m) cliente(s) relacionado(s) à este tipo de cliente, por isso não é possível excluí-lo.");
		}
	}

	@Override
	public void buscaSeConsorcioEstaRelacionadoComCliente(Integer consorcioId) {
		log.info("[inicia] ClienteRepositoryDB - buscaSeConsorcioEstaRelacionadoComCliente");
		if (clienteRepositoryJpa.findFirstByConsorcioId(consorcioId).isPresent()) {
			log.info("[finaliza] ClienteRepositoryDB - buscaSeConsorcioEstaRelacionadoComCliente");
			throw APIException.build(HttpStatus.BAD_REQUEST,
					"Existe(m) cliente(s) relacionado(s) à este consórcio, por isso não é possível excluí-lo.");
		}
		
	}

	@Override
	public void buscaSeServidorEstaRelacionadoComCliente(Integer servidorId) {
		log.info("[inicia] ClienteRepositoryDB - buscaSeServidorEstaRelacionadoComCliente");
		if (clienteRepositoryJpa.findFirstByServidorPortaIdOrServidorBancoId(servidorId,servidorId).isPresent()) {
			log.info("[finaliza] ClienteRepositoryDB - buscaSeServidorEstaRelacionadoComCliente");
			throw APIException.build(HttpStatus.BAD_REQUEST,
					"Existe(m) cliente(s) relacionado(s) à este servidor, por isso não é possível excluí-lo.");
		}
	}

	@Override
	public void deletaCliente(Cliente cliente) {
		log.info("[inicia] ClienteRepositoryDB - deletaCliente");
		clienteRepositoryJpa.delete(cliente);
		log.info("[finaliza] ClienteRepositoryDB - deletaCliente");		
	}

	@Override
	public Cliente buscaClientePorId(Integer clienteId) {
		log.info("[inicia] ClienteRepositoryDB - buscaClientePorId");
		Cliente cliente = clienteRepositoryJpa.findById(clienteId)
				.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Cliente não encontrado."));
		log.info("[finaliza] ClienteRepositoryDB - buscaClientePorId");		
		return cliente;
	}

	@Override
	public List<Cliente> buscaTodosCliente() {
		log.info("[inicia] ClienteRepositoryDB - buscaTodosCliente");
		List<Cliente> clientes = clienteRepositoryJpa.findAll();
		log.info("[finaliza] ClienteRepositoryDB - buscaTodosCliente");		
		return clientes;
	}

	@Override
	public List<Cliente> buscaClientesPorIbge(Integer clienteIbge) {
		log.info("[inicia] ClienteRepositoryDB - buscaClientesPorIbge");
		List<Cliente> clientes = clienteRepositoryJpa.buscaClientesPorIbge(clienteIbge.toString());
		log.info("[finaliza] ClienteRepositoryDB - buscaClientesPorIbge");		
		return clientes;
	}

	@Override
	public List<Cliente> buscaClientesPorDescricao(String clienteDescricao) {
		log.info("[inicia] ClienteRepositoryDB - buscaClientesPorIbge");
		List<Cliente> clientes = clienteRepositoryJpa.buscaClientesPorDescricao(clienteDescricao);
		log.info("[finaliza] ClienteRepositoryDB - buscaClientesPorIbge");		
		return clientes;
	}

}