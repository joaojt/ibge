package dev.joaojt.ibge.consorcio.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ConsorcioEditaRequest {
	
    @Size(message = "A descrição do consórcio deve ter entre 5 e 50 caracteres.", min = 5, max = 50)
    @NotBlank(message = "A descrição do consórcio não pode ser nula ou vazia.")
	private String descricao;	
    
}