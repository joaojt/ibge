package dev.joaojt.ibge.cliente.application.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/cliente")
public interface ClienteAPI {
	
	@PostMapping(value = "/insere")
	@ResponseStatus(code = HttpStatus.CREATED)
	void insereCliente(@RequestBody @Valid ClienteNovoRequest clienteNovo);

	@DeleteMapping(value = "/deleta/{clienteId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaCliente(@PathVariable Integer clienteId);
	
	@GetMapping(value = "/busca-cliente-por-id/{clienteId}")
	@ResponseStatus(code = HttpStatus.OK)
	ClienteResponse buscaClientePorId(@PathVariable Integer clienteId);
	
	@GetMapping(value = "/busca-todos")
	@ResponseStatus(code = HttpStatus.OK)
	List<ClienteResponse> buscaTodosCliente();
	
	@GetMapping(value = "/busca-clientes-por-ibge/{clienteIbge}")
	@ResponseStatus(code = HttpStatus.OK)
	List<ClienteResponse> buscaClientesPorIbge(@PathVariable Integer clienteIbge);
	
	@GetMapping(value = "/busca-clientes-por-descricao/{clienteDescricao}")
	@ResponseStatus(code = HttpStatus.OK)
	List<ClienteResponse> buscaClientesPorDescricao(@PathVariable String clienteDescricao);
		
	@PatchMapping(value = "/edita/{clienteId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void editaCliente(@PathVariable Integer clienteId, @RequestBody @Valid ClienteEditaRequest clienteEdita);
	
}