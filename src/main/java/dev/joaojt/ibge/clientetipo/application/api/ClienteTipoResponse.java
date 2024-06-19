package dev.joaojt.ibge.clientetipo.application.api;

import java.util.List;
import java.util.stream.Collectors;

import dev.joaojt.ibge.clientetipo.domain.ClienteTipo;
import lombok.Getter;

@Getter
public class ClienteTipoResponse {
	
	private Integer id;
	private String descricao;	
	
	public ClienteTipoResponse(ClienteTipo clienteTipo) {
		this.id = clienteTipo.getId();
		this.descricao = clienteTipo.getDescricao();
	}

	public static List<ClienteTipoResponse> converter(List<ClienteTipo> clienteTipos) {
		return clienteTipos.stream()
				.map(ClienteTipoResponse::new)
				.collect(Collectors.toList());
	}	
	
}