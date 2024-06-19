package dev.joaojt.ibge.consorcio.application.service;

import java.util.List;

import dev.joaojt.ibge.consorcio.application.api.ConsorcioEditaRequest;
import dev.joaojt.ibge.consorcio.application.api.ConsorcioNovoRequest;
import dev.joaojt.ibge.consorcio.application.api.ConsorcioResponse;

public interface ConsorcioService {

	void insereConsorcio(ConsorcioNovoRequest consorcioNovo);

	void deletaConsorcio(Integer consorcioId);

	void editaConsorcio(Integer consorcioId, ConsorcioEditaRequest consorcioEdita);

	ConsorcioResponse buscaConsorcioPorId(Integer consorcioId);

	List<ConsorcioResponse> buscaTodosConsorcio();
	
}