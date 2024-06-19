package dev.joaojt.ibge.cliente.application.repository;

import dev.joaojt.ibge.cliente.domain.Cliente;

public interface ClienteRepository {

	void salvaCliente(Cliente cliente);

	void buscaSeClienteTipoEstaRelacionadoComCliente(Integer clienteTipoId);

	void buscaSeConsorcioEstaRelacionadoComCliente(Integer consorcioId);

	void buscaSeServidorEstaRelacionadoComCliente(Integer servidorId);

}