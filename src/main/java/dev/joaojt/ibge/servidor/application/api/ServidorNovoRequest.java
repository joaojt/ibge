package dev.joaojt.ibge.servidor.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ServidorNovoRequest {
	
    @Size(message = "O IP do servidor deve ter entre 5 e 15 caracteres.", min = 5, max = 50)
    @NotBlank(message = "O IP do servidor não pode ser nulo ou vazio.")
	private String ip;
    @Size(message = "O tipo do servidor deve ter entre 5 e 15 caracteres.", min = 5, max = 50)
    @NotBlank(message = "O tipo do servidor não pode ser nulo ou vazio.")
	private String tipo;
    
}