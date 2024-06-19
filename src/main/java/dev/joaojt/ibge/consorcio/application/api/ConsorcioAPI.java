package dev.joaojt.ibge.consorcio.application.api;

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
@RequestMapping("api/consorcio")
public interface ConsorcioAPI {
	
	@PostMapping(value = "/insere")
	@ResponseStatus(code = HttpStatus.CREATED)
	void insereConsorcio(@RequestBody @Valid ConsorcioNovoRequest consorcioNovo);
	
	@DeleteMapping(value = "/deleta/{consorcioId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaConsorcio(@PathVariable Integer consorcioId);
	
	@PatchMapping(value = "/edita/{consorcioId}")
	@ResponseStatus(code = HttpStatus.OK)
	void editaConsorcio(@PathVariable Integer consorcioId, @RequestBody @Valid ConsorcioEditaRequest consorcioEdita);
	
	@GetMapping(value = "/busca/{consorcioId}")
	@ResponseStatus(code = HttpStatus.OK)
	ConsorcioResponse buscaConsorcioPorId(@PathVariable Integer consorcioId);
	
	@GetMapping(value = "/busca-todos")
	@ResponseStatus(code = HttpStatus.OK)
	List<ConsorcioResponse> buscaTodosConsorcio();			
	
}
