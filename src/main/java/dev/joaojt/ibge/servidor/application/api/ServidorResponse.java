package dev.joaojt.ibge.servidor.application.api;

import java.util.List;
import java.util.stream.Collectors;

import dev.joaojt.ibge.servidor.domain.Servidor;
import lombok.Getter;

@Getter
public class ServidorResponse {
	
	private Integer id;
	private String ip;
	private String tipo;
	
	public ServidorResponse(Servidor servidor) {
		this.id = servidor.getId();
		this.ip = servidor.getIp();
		this.tipo = servidor.getTipo();
	}

	public static List<ServidorResponse> converter(List<Servidor> servidores) {
		return servidores.stream()
				.map(ServidorResponse::new)
				.collect(Collectors.toList());
	}	
}