package dev.joaojt.ibge.clientetipo.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClienteTipoEditaRequest {

    @Size(message = "A descrição do tipo do cliente deve ter entre 5 e 50 caracteres.", min = 5, max = 50)
    @NotBlank(message = "A descrição do tipo do cliente não pode ser nula ou vazia.")
	private String descricao;	

}