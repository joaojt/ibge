package dev.joaojt.ibge.cliente.infra;

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

}