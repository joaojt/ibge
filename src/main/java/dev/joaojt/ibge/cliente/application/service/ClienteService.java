package dev.joaojt.ibge.cliente.application.service;

import dev.joaojt.ibge.cliente.application.api.ClienteNovoRequest;

public interface ClienteService {

	void insereCliente(ClienteNovoRequest clienteNovo);

}