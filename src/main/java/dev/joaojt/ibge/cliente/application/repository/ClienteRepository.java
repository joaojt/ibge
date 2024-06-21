package dev.joaojt.ibge.cliente.application.repository;

import java.util.List;

import dev.joaojt.ibge.cliente.domain.Cliente;

public interface ClienteRepository {

	void salvaCliente(Cliente cliente);

	void buscaSeClienteTipoEstaRelacionadoComCliente(Integer clienteTipoId);

	void buscaSeConsorcioEstaRelacionadoComCliente(Integer consorcioId);

	void buscaSeServidorEstaRelacionadoComCliente(Integer servidorId);

	void deletaCliente(Cliente cliente);

	Cliente buscaClientePorId(Integer clienteId);

	List<Cliente> buscaTodosCliente();

	List<Cliente> buscaClientesPorIbge(Integer clienteIbge);

	List<Cliente> buscaClientesPorDescricao(String clienteDescricao);

}