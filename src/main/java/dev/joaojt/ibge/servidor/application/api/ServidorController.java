package dev.joaojt.ibge.servidor.application.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import dev.joaojt.ibge.servidor.application.service.ServidorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ServidorController implements ServidorAPI{
	
	private final ServidorService servidorService;

	@Override
	public void insereServidor(ServidorNovoRequest servidorNovo) {
		log.info("[inicia] ServidorController - insereServidor");
		servidorService.insereServidor(servidorNovo);
		log.info("[finaliza] ServidorController - insereServidor");			
	}

	@Override
	public ServidorResponse buscaServidorPorId(Integer servidorId) {
		log.info("[inicia] ServidorController - buscaServidorPorId");
		ServidorResponse servidorResponse = servidorService.buscaServidorPorId(servidorId);
		log.info("[finaliza] ServidorController - buscaServidorPorId");		
		return servidorResponse;
	}

	@Override
	public List<ServidorResponse> buscaTodosServidor() {
		log.info("[inicia] ServidorController - buscaTodosServidor");
		List<ServidorResponse> servidoresResponse = servidorService.buscaTodosServidor();
		log.info("[finaliza] ServidorController - buscaTodosServidor");		
		return servidoresResponse;
	}

	@Override
	public void deletaServidor(Integer servidorId) {
		log.info("[inicia] ServidorController - deletaServidor");
		servidorService.deletaServidor(servidorId);
		log.info("[finaliza] ServidorController - deletaServidor");	
	}

	@Override
	public void editaServidor(Integer servidorId, ServidorEditaRequest servidorEdita) {
		log.info("[inicia] ServidorController - editaServidor");
		servidorService.editaServidor(servidorId,servidorEdita);
		log.info("[finaliza] ServidorController - editaServidor");	
	}

}