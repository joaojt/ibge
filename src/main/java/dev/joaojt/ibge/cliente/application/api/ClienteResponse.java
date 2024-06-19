package dev.joaojt.ibge.cliente.application.api;

import dev.joaojt.ibge.clientetipo.domain.ClienteTipo;
import dev.joaojt.ibge.consorcio.domain.Consorcio;
import dev.joaojt.ibge.servidor.domain.Servidor;
import lombok.Getter;

@Getter
public class ClienteResponse {
	
	private Integer id;
	private String descricao;
    private Integer ibge;
    private Boolean prontoAtendimento;
    private Boolean appAcs;
    private Boolean appACE;
    private Boolean painelSenha;
    private Servidor idServidorPorta;
    private Servidor idServidorBanco;
    private String versao;
    private Consorcio idConsorcio;
    private String aliasBanco;
    private Integer portaFirebirdBanco;
    private ClienteTipo idClienteTipo;
    private Integer portaTcpA;
    private Integer portaTcpB;
    private Integer portaTcpC;
    private Integer portaTcpD;
    private Integer portaHttpA;
    private Integer portaHttpB;
    private Integer portaHttpC;
    private Integer portaHttpD;

}