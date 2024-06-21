package dev.joaojt.ibge.servidor.infra;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import dev.joaojt.ibge.handler.APIException;
import dev.joaojt.ibge.servidor.application.repository.ServidorRepository;
import dev.joaojt.ibge.servidor.domain.Servidor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
@RequiredArgsConstructor
public class ServidorRepositoryDB implements ServidorRepository{
	
	private final ServidorRepositoryJpa servidorRepositoryJpa;

	@Override
	public Servidor buscaServidorPorId(Integer servidorId) {
		log.info("[inicia] ServidorRepositoryDB - buscaServidorPorId");
		Servidor servidor = servidorRepositoryJpa.findById(servidorId)
				.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Servidor não encontrado."));
		log.info("[finaliza] ServidorRepositoryDB - buscaServidorPorId");
		return servidor;
	}

	@Override
	public void salvaServidor(Servidor servidor) {
		log.info("[inicia] ServidorRepositoryDB - salvaServidor");
		servidorRepositoryJpa.save(servidor);
 		log.info("[finaliza] ServidorRepositoryDB - salvaServidor");		
	}

	@Override
	public List<Servidor> buscaTodosServidor() {
		log.info("[inicia] ServidorRepositoryDB - buscaTodosServidor");
		List<Servidor> servidores = servidorRepositoryJpa.findAll();
		log.info("[finaliza] ServidorRepositoryDB - buscaTodosServidor");		
		return servidores;
	}

	@Override
	public void deletaServidor(Servidor servidor) {
		log.info("[inicia] ServidorRepositoryDB - deletaServidor");
		servidorRepositoryJpa.delete(servidor);
		log.info("[finaliza] ServidorRepositoryDB - deletaServidor");				
	}

}