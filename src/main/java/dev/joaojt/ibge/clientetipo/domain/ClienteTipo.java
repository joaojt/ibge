package dev.joaojt.ibge.clientetipo.domain;

import dev.joaojt.ibge.clientetipo.application.api.ClienteTipoEditaRequest;
import dev.joaojt.ibge.clientetipo.application.api.ClienteTipoNovoRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClienteTipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    @Size(message = "A descrição do tipo do cliente deve ter entre 5 e 50 caracteres.", min = 5, max = 50)
    @NotBlank(message = "A descrição do tipo do cliente não pode ser nula ou vazia.")
	private String descricao;	
    
	public ClienteTipo(ClienteTipoNovoRequest clienteTipoNovo) {
		this.descricao = clienteTipoNovo.getDescricao();
	}

	public void editaClienteTipo(ClienteTipoEditaRequest clienteTipoEdita) {
		this.descricao = clienteTipoEdita.getDescricao();		
	}    

}