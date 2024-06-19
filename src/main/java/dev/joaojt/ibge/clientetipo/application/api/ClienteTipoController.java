package dev.joaojt.ibge.clientetipo.application.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import dev.joaojt.ibge.clientetipo.application.service.ClienteTipoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ClienteTipoController implements ClienteTipoAPI{
	
	private final ClienteTipoService clienteTipoService;

	@Override
	public void insereClienteTipo(ClienteTipoNovoRequest clienteTipoNovo) {
		log.info("[inicia] ClienteTipoController - insereClienteTipo");
		clienteTipoService.insereClienteTipo(clienteTipoNovo);
		log.info("[finaliza] ClienteTipoController - insereClienteTipo");	
	}

	@Override
	public void deletaClienteTipo(Integer clienteTipoId) {
		log.info("[inicia] ClienteTipoController - deletaClienteTipo");
		clienteTipoService.deletaClienteTipo(clienteTipoId);
		log.info("[finaliza] ClienteTipoController - deletaClienteTipo");
	}

	@Override
	public void editaClienteTipo(Integer clienteTipoId, ClienteTipoEditaRequest clienteTipoEdita) {
		log.info("[inicia] ClienteTipoController - editaClienteTipo");
		clienteTipoService.editaClienteTipo(clienteTipoId,clienteTipoEdita);
		log.info("[finaliza] ClienteTipoController - editaClienteTipo");
	}

	@Override
	public ClienteTipoResponse buscaClienteTipoPorId(Integer clienteTipoId) {
		log.info("[inicia] ClienteTipoController - buscaClienteTipoPorId");
		ClienteTipoResponse clienteTipoResponse = clienteTipoService.buscaClienteTipoPorId(clienteTipoId);
		log.info("[finaliza] ClienteTipoController - buscaClienteTipoPorId");
		return clienteTipoResponse;
	}

	@Override
	public List<ClienteTipoResponse> buscaTodosClienteTipo() {
		log.info("[inicia] ClienteTipoController - buscaTodosClienteTipo");
		List<ClienteTipoResponse> clienteTipos = clienteTipoService.buscaTodosClienteTipo();
		log.info("[finaliza] ClienteTipoController - buscaTodosClienteTipo");
		return clienteTipos;
	}

}