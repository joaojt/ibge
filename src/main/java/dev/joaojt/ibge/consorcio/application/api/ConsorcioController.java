package dev.joaojt.ibge.consorcio.application.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import dev.joaojt.ibge.consorcio.application.service.ConsorcioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ConsorcioController implements ConsorcioAPI{
	
	private final ConsorcioService consorcioService;

	@Override
	public void insereConsorcio(ConsorcioNovoRequest consorcioNovo) {
		log.info("[inicia] ConsorcioController - insereConsorcio");
		consorcioService.insereConsorcio(consorcioNovo);
		log.info("[finaliza] ConsorcioController - insereConsorcio");	
	}

	@Override
	public void deletaConsorcio(Integer consorcioId) {
		log.info("[inicia] ConsorcioController - deletaConsorcio");
		consorcioService.deletaConsorcio(consorcioId);
		log.info("[finaliza] ConsorcioController - deletaConsorcio");	
	}

	@Override
	public void editaConsorcio(Integer consorcioId, ConsorcioEditaRequest consorcioEdita) {
		log.info("[inicia] ConsorcioController - editaConsorcio");
		consorcioService.editaConsorcio(consorcioId,consorcioEdita);
		log.info("[finaliza] ConsorcioController - editaConsorcio");		
	}

	@Override
	public ConsorcioResponse buscaConsorcioPorId(Integer consorcioId) {
		log.info("[inicia] ConsorcioController - buscaConsorcioPorId");
		ConsorcioResponse consorcioResponse = consorcioService.buscaConsorcioPorId(consorcioId);
		log.info("[finaliza] ConsorcioController - buscaConsorcioPorId");		
		return consorcioResponse;
	}

	@Override
	public List<ConsorcioResponse> buscaTodosConsorcio() {
		log.info("[inicia] ConsorcioController - buscaTodosConsorcio");
		List<ConsorcioResponse> consorciosResponse = consorcioService.buscaTodosConsorcio();
		log.info("[finaliza] ConsorcioController - buscaTodosConsorcio");		
		return consorciosResponse;
	}

}