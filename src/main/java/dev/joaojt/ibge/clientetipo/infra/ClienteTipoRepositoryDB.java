package dev.joaojt.ibge.clientetipo.infra;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import dev.joaojt.ibge.clientetipo.application.repository.ClienteTipoRepository;
import dev.joaojt.ibge.clientetipo.domain.ClienteTipo;
import dev.joaojt.ibge.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
@RequiredArgsConstructor
public class ClienteTipoRepositoryDB implements ClienteTipoRepository{
	
	private final ClienteTipoRepositoryJpa clienteTipoRepositoryJpa;

	@Override
	public ClienteTipo buscaClienteTipoPorId(Integer idClienteTipo) {
		log.info("[inicia] ClienteTipoRepositoryDB - buscaClienteTipoPorId");
		ClienteTipo clienteTipo = clienteTipoRepositoryJpa.findById(idClienteTipo)
				.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Tipo de cliente não encontrado."));
		log.info("[finaliza] ClienteTipoRepositoryDB - buscaClienteTipoPorId");
		return clienteTipo;
	}

	@Override
	public void salvaClienteTipo(ClienteTipo clienteTipo) {
		log.info("[inicia] ClienteTipoRepositoryDB - salvaClienteTipo");
		clienteTipoRepositoryJpa.save(clienteTipo);
		log.info("[finaliza] ClienteTipoRepositoryDB - salvaClienteTipo");
	}

	@Override
	public void deletaClienteTipo(ClienteTipo clienteTipo) {
		log.info("[inicia] ClienteTipoRepositoryDB - deletaClienteTipo");
		clienteTipoRepositoryJpa.delete(clienteTipo);
		log.info("[finaliza] ClienteTipoRepositoryDB - deletaClienteTipo");
	}

	@Override
	public List<ClienteTipo> buscaTodosClienteTipo() {
		log.info("[inicia] ClienteTipoRepositoryDB - buscaTodosClienteTipo");
		List<ClienteTipo> clienteTipos = clienteTipoRepositoryJpa.findAll();
		log.info("[finaliza] ClienteTipoRepositoryDB - buscaTodosClienteTipo");
		return clienteTipos;
	}
	
}