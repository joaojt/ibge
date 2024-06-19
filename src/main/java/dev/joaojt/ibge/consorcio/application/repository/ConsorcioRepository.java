package dev.joaojt.ibge.consorcio.application.repository;

import java.util.List;

import dev.joaojt.ibge.consorcio.domain.Consorcio;

public interface ConsorcioRepository {

	Consorcio buscaConsorcioPorId(Integer idConsorcio);

	void salvaConsorcio(Consorcio consorcio);

	void deletaConsorcio(Consorcio consorcio);

	List<Consorcio> buscaTodosConsorcio();
	
}