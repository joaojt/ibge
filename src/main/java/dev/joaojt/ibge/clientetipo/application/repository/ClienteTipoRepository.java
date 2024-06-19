package dev.joaojt.ibge.clientetipo.application.repository;

import java.util.List;

import dev.joaojt.ibge.clientetipo.domain.ClienteTipo;

public interface ClienteTipoRepository {

	ClienteTipo buscaClienteTipoPorId(Integer idClienteTipo);

	void salvaClienteTipo(ClienteTipo clienteTipo);

	void deletaClienteTipo(ClienteTipo clienteTipo);

	List<ClienteTipo> buscaTodosClienteTipo();

}