package dev.joaojt.ibge.servidor.application.service;

import java.util.List;

import dev.joaojt.ibge.servidor.application.api.ServidorEditaRequest;
import dev.joaojt.ibge.servidor.application.api.ServidorNovoRequest;
import dev.joaojt.ibge.servidor.application.api.ServidorResponse;

public interface ServidorService {

	void insereServidor(ServidorNovoRequest servidorNovo);

	ServidorResponse buscaServidorPorId(Integer servidorId);

	List<ServidorResponse> buscaTodosServidor();

	void deletaServidor(Integer servidorId);

	void editaServidor(Integer servidorId, ServidorEditaRequest servidorEdita);

}
