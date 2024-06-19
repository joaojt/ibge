package dev.joaojt.ibge.clientetipo.application.api;

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
@RequestMapping("api/cliente-tipo")
public interface ClienteTipoAPI {
	
	@PostMapping(value = "/insere")
	@ResponseStatus(code = HttpStatus.CREATED)
	void insereClienteTipo(@RequestBody @Valid ClienteTipoNovoRequest clienteTipoNovo);
	
	@DeleteMapping(value = "/deleta/{clienteTipoId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaClienteTipo(@PathVariable Integer clienteTipoId);
	
	@PatchMapping(value = "/edita/{clienteTipoId}")
	@ResponseStatus(code = HttpStatus.OK)
	void editaClienteTipo(@PathVariable Integer clienteTipoId, @RequestBody @Valid ClienteTipoEditaRequest clienteTipoEdita);
	
	@GetMapping(value = "/busca/{clienteTipoId}")
	@ResponseStatus(code = HttpStatus.OK)
	ClienteTipoResponse buscaClienteTipoPorId(@PathVariable Integer clienteTipoId);
	
	@GetMapping(value = "/busca-todos")
	@ResponseStatus(code = HttpStatus.OK)
	List<ClienteTipoResponse> buscaTodosClienteTipo();		

}