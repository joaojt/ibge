package dev.joaojt.ibge.consorcio.infra;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import dev.joaojt.ibge.consorcio.application.repository.ConsorcioRepository;
import dev.joaojt.ibge.consorcio.domain.Consorcio;
import dev.joaojt.ibge.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
@RequiredArgsConstructor
public class ConsorcioRepositoryDB implements ConsorcioRepository{
	
	private final ConsorcioRepositoryJpa consorcioRepositoryJpa;

	@Override
	public Consorcio buscaConsorcioPorId(Integer idConsorcio) {
		log.info("[inicia] ConsorcioRepositoryDB - buscaConsorcioPorId");
		Consorcio consorcio = consorcioRepositoryJpa.findById(idConsorcio)
				.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Consórcio não encontrado."));
		log.info("[finaliza] ConsorcioRepositoryDB - buscaConsorcioPorId");
		return consorcio;
	}

	@Override
	public void salvaConsorcio(Consorcio consorcio) {
		log.info("[inicia] ConsorcioRepositoryDB - salvaConsorcio");
		consorcioRepositoryJpa.save(consorcio);		
		log.info("[finaliza] ConsorcioRepositoryDB - salvaConsorcio");
	}

	@Override
	public void deletaConsorcio(Consorcio consorcio) {
		log.info("[inicia] ConsorcioRepositoryDB - deletaConsorcio");
		consorcioRepositoryJpa.delete(consorcio);	
		log.info("[finaliza] ConsorcioRepositoryDB - deletaConsorcio");
	}

	@Override
	public List<Consorcio> buscaTodosConsorcio() {
		log.info("[inicia] ConsorcioRepositoryDB - deletaConsorcio");
		List<Consorcio> consorcios = consorcioRepositoryJpa.findAll();
		log.info("[finaliza] ConsorcioRepositoryDB - deletaConsorcio");
		return consorcios;
	}
	
}