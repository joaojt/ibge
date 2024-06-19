package dev.joaojt.ibge.servidor.application.repository;

import java.util.List;

import dev.joaojt.ibge.servidor.domain.Servidor;

public interface ServidorRepository {

	Servidor buscaServidorPorId(Integer idServidor);

	void salvaServidor(Servidor servidor);

	List<Servidor> buscaTodosServidor();

	void deletaServidor(Servidor servidor);

}