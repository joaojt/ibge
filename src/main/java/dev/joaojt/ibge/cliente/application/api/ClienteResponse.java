package dev.joaojt.ibge.cliente.application.api;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import dev.joaojt.ibge.cliente.domain.Cliente;
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
    private Integer portaTcpa;
    private Integer portaTcpb;
    private Integer portaTcpc;
    private Integer portaTcpd;
    private Integer portaHttpa;
    private Integer portaHttpb;
    private Integer portaHttpc;
    private Integer portaHttpd;

	public ClienteResponse(Cliente cliente) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(cliente, this);
	}

	public static List<ClienteResponse> converter(List<Cliente> clientes) {
		return clientes.stream()
				.map(ClienteResponse::new)
				.collect(Collectors.toList());
	}    
	
}