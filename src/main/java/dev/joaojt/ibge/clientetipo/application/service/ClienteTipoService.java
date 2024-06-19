package dev.joaojt.ibge.clientetipo.application.service;

import java.util.List;

import dev.joaojt.ibge.clientetipo.application.api.ClienteTipoEditaRequest;
import dev.joaojt.ibge.clientetipo.application.api.ClienteTipoNovoRequest;
import dev.joaojt.ibge.clientetipo.application.api.ClienteTipoResponse;

public interface ClienteTipoService {

	void insereClienteTipo(ClienteTipoNovoRequest clienteTipoNovo);

	void deletaClienteTipo(Integer clienteTipoId);

	ClienteTipoResponse buscaClienteTipoPorId(Integer clienteTipoId);

	List<ClienteTipoResponse> buscaTodosClienteTipo();

	void editaClienteTipo(Integer clienteTipoId, ClienteTipoEditaRequest clienteTipoEdita);

}