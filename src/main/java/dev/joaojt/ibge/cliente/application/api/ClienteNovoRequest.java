package dev.joaojt.ibge.cliente.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClienteNovoRequest {
	
	@Size(message = "A descricao do cliente deve ter entre 5 e 50 caracteres.", min = 5, max = 50)
    @NotBlank(message = "A descrição do cliente não pode ser nula ou vazia.")
	private String descricao;
    private Integer ibge;
    private Boolean prontoAtendimento;
    private Boolean appAcs;
    private Boolean appAce;
    private Boolean painelSenha;
    private Integer idServidorPorta;
    private Integer idServidorBanco;
    private String versao;
    private Integer idConsorcio;
    private String aliasBanco;
    private Integer portaFirebirdBanco;
    private Integer idClienteTipo;
    private Integer portaTcpA;
    private Integer portaTcpB;
    private Integer portaTcpC;
    private Integer portaTcpD;
    private Integer portaHttpA;
    private Integer portaHttpB;
    private Integer portaHttpC;
    private Integer portaHttpD;

}