package dev.joaojt.ibge.cliente.application.service;

import java.util.List;

import dev.joaojt.ibge.cliente.application.api.ClienteEditaRequest;
import dev.joaojt.ibge.cliente.application.api.ClienteNovoRequest;
import dev.joaojt.ibge.cliente.application.api.ClienteResponse;

public interface ClienteService {

	void insereCliente(ClienteNovoRequest clienteNovo);

	void deletaCliente(Integer clienteId);

	ClienteResponse buscaClientePorId(Integer clienteId);

	List<ClienteResponse> buscaTodosCliente();

	List<ClienteResponse> buscaClientesPorIbge(Integer clienteIbge);

	List<ClienteResponse> buscaClientesPorDescricao(String clienteDescricao);

	void editaCliente(Integer clienteId, ClienteEditaRequest clienteEdita);

}