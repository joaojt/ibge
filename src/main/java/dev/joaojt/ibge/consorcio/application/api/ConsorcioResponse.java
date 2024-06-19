package dev.joaojt.ibge.consorcio.application.api;

import java.util.List;
import java.util.stream.Collectors;

import dev.joaojt.ibge.consorcio.domain.Consorcio;
import lombok.Getter;

@Getter
public class ConsorcioResponse {
	
	private Integer id;
	private String descricao;	
	
	public ConsorcioResponse(Consorcio consorcio) {
		this.id = consorcio.getId();
		this.descricao = consorcio.getDescricao();
	}

	public static List<ConsorcioResponse> converter(List<Consorcio> consorcios) {
		return consorcios.stream()
				.map(ConsorcioResponse::new)
				.collect(Collectors.toList());
	}	
	
}