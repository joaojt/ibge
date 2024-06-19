package dev.joaojt.ibge.servidor.domain;

import dev.joaojt.ibge.servidor.application.api.ServidorEditaRequest;
import dev.joaojt.ibge.servidor.application.api.ServidorNovoRequest;
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
public class Servidor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    @Size(message = "O IP do servidor deve ter entre 5 e 15 caracteres.", min = 5, max = 50)
    @NotBlank(message = "O IP do servidor não pode ser nulo ou vazio.")
	private String ip;
    @Size(message = "O tipo do servidor deve ter entre 5 e 15 caracteres.", min = 5, max = 50)
    @NotBlank(message = "O tipo do servidor não pode ser nulo ou vazio.")
	private String tipo;
    
	public Servidor(ServidorNovoRequest servidorNovo) {
		this.ip = servidorNovo.getIp();
		this.tipo = servidorNovo.getTipo();
	}

	public void editaServidor(ServidorEditaRequest servidorEdita) {
		this.ip = servidorEdita.getIp();
		this.tipo = servidorEdita.getTipo();
	}    
    
}