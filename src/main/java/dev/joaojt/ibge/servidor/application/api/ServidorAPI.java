package dev.joaojt.ibge.servidor.application.api;

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
@RequestMapping("api/servidor")
public interface ServidorAPI {
	
	@PostMapping(value = "/insere")
	@ResponseStatus(code = HttpStatus.CREATED)
	void insereServidor(@RequestBody @Valid ServidorNovoRequest servidorNovo);
	
	@GetMapping(value = "/busca/{servidorId}")
	@ResponseStatus(code = HttpStatus.OK)
	ServidorResponse buscaServidorPorId(@PathVariable Integer servidorId);
	
	@GetMapping(value = "/busca-todos")
	@ResponseStatus(code = HttpStatus.OK)
	List<ServidorResponse> buscaTodosServidor();
	
	@DeleteMapping(value = "/deleta/{promocaoId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaServidor(@PathVariable Integer servidorId);
	
	@PatchMapping(value = "/edita/{promocaoId}")
	@ResponseStatus(code = HttpStatus.OK)
	void editaServidor(@PathVariable Integer servidorId, @RequestBody @Valid ServidorEditaRequest servidorEdita);
	
}
