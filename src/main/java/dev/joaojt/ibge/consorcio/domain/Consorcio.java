package dev.joaojt.ibge.consorcio.domain;

import dev.joaojt.ibge.consorcio.application.api.ConsorcioEditaRequest;
import dev.joaojt.ibge.consorcio.application.api.ConsorcioNovoRequest;
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
public class Consorcio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    @Size(message = "A descrição do consórcio deve ter entre 5 e 50 caracteres.", min = 5, max = 50)
    @NotBlank(message = "A descrição do consórcio não pode ser nula ou vazia.")
	private String descricao;	
    
	public Consorcio(ConsorcioNovoRequest consorcioNovo) {
		this.descricao = consorcioNovo.getDescricao();
	}

	public void editaConsorcio(ConsorcioEditaRequest consorcioEdita) {
		this.descricao = consorcioEdita.getDescricao();
	}    

}