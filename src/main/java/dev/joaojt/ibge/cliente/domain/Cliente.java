package dev.joaojt.ibge.cliente.domain;

import java.util.Optional;

import org.modelmapper.ModelMapper;

import dev.joaojt.ibge.cliente.application.api.ClienteEditaRequest;
import dev.joaojt.ibge.cliente.application.api.ClienteNovoRequest;
import dev.joaojt.ibge.clientetipo.domain.ClienteTipo;
import dev.joaojt.ibge.consorcio.domain.Consorcio;
import dev.joaojt.ibge.servidor.domain.Servidor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    @Size(message = "A descricao do cliente deve ter entre 5 e 50 caracteres.", min = 5, max = 50)
    @NotBlank(message = "A descrição do cliente não pode ser nula ou vazia.")
	private String descricao;
    private Integer ibge;
    private Boolean prontoAtendimento;
    private Boolean appAcs;
    private Boolean appAce;
    private Boolean painelSenha;
    @ManyToOne
    @JoinColumn(name = "idServidorPorta")
    private Servidor servidorPorta;
    @ManyToOne
    @JoinColumn(name = "idServidorBanco")    
    private Servidor servidorBanco;
    private String versao;
    @ManyToOne
    @JoinColumn(name = "idConsorcio")
    private Consorcio consorcio;
    private String aliasBanco;
    private Integer portaFirebirdBanco;
    @ManyToOne
    @JoinColumn(name = "idClienteTipo")
    private ClienteTipo clienteTipo;
    private Integer portaTcpa;
    private Integer portaTcpb;
    private Integer portaTcpc;
    private Integer portaTcpd;
    private Integer portaHttpa;
    private Integer portaHttpb;
    private Integer portaHttpc;
    private Integer portaHttpd;
    
	public Cliente(ClienteNovoRequest clienteNovo, Servidor servidorPorta, Servidor servidorBanco,
			Consorcio consorcio, ClienteTipo clienteTipo) {
		this.descricao = clienteNovo.getDescricao();
		Optional.ofNullable(clienteNovo.getIbge()).ifPresent(ibge -> this.ibge = ibge);
		Optional.ofNullable(clienteNovo.getProntoAtendimento()).ifPresent(prontoAtendimento -> this.prontoAtendimento = prontoAtendimento);
		Optional.ofNullable(clienteNovo.getAppAcs()).ifPresent(appAcs -> this.appAcs = appAcs);
		Optional.ofNullable(clienteNovo.getAppAce()).ifPresent(appAce -> this.appAce = appAce);
		Optional.ofNullable(clienteNovo.getPainelSenha()).ifPresent(painelSenha -> this.painelSenha = painelSenha);
		Optional.ofNullable(servidorPorta).ifPresent(eServidorPorta -> this.servidorPorta = eServidorPorta);
		Optional.ofNullable(servidorBanco).ifPresent(eServidorBanco -> this.servidorBanco = eServidorBanco);
		Optional.ofNullable(clienteNovo.getVersao()).ifPresent(versao -> this.versao = versao);
		Optional.ofNullable(consorcio).ifPresent(eConsorcio -> this.consorcio = eConsorcio);
		Optional.ofNullable(clienteNovo.getAliasBanco()).ifPresent(aliasBanco -> this.aliasBanco = aliasBanco);
		Optional.ofNullable(clienteNovo.getPortaFirebirdBanco()).ifPresent(portaFirebirdBanco -> this.portaFirebirdBanco = portaFirebirdBanco);
		Optional.ofNullable(clienteTipo).ifPresent(eClienteTipo -> this.clienteTipo = eClienteTipo);	
		Optional.ofNullable(clienteNovo.getPortaTcpa()).ifPresent(portaTcpa -> this.portaTcpa = portaTcpa);
		Optional.ofNullable(clienteNovo.getPortaTcpb()).ifPresent(portaTcpb -> this.portaTcpb = portaTcpb);
		Optional.ofNullable(clienteNovo.getPortaTcpc()).ifPresent(portaTcpc -> this.portaTcpc = portaTcpc);
		Optional.ofNullable(clienteNovo.getPortaTcpd()).ifPresent(portaTcpd -> this.portaTcpd = portaTcpd);
		Optional.ofNullable(clienteNovo.getPortaHttpa()).ifPresent(portaHttpa -> this.portaHttpa = portaHttpa);
		Optional.ofNullable(clienteNovo.getPortaHttpb()).ifPresent(portaHttpb -> this.portaHttpb = portaHttpb);
		Optional.ofNullable(clienteNovo.getPortaHttpc()).ifPresent(portaHttpc -> this.portaHttpc = portaHttpc);
		Optional.ofNullable(clienteNovo.getPortaHttpd()).ifPresent(portaHttpd -> this.portaHttpd = portaHttpd);
	}

	public Cliente(ClienteEditaRequest clienteEdita, Servidor servidorPorta, Servidor servidorBanco,
			Consorcio consorcio, ClienteTipo clienteTipo) {
		this.descricao = clienteEdita.getDescricao(); 
		this.ibge = clienteEdita.getIbge(); 
		this.prontoAtendimento = clienteEdita.getProntoAtendimento(); 
		this.appAcs = clienteEdita.getAppAcs(); 
		this.appAce = clienteEdita.getAppAce(); 
		this.painelSenha = clienteEdita.getPainelSenha(); 
		this.servidorPorta = servidorPorta; 
		this.servidorBanco = servidorBanco; 
		this.versao = clienteEdita.getVersao(); 
		this.consorcio = consorcio; 
		this.aliasBanco = clienteEdita.getAliasBanco(); 
		this.portaFirebirdBanco = clienteEdita.getPortaFirebirdBanco(); 
		this.clienteTipo = clienteTipo; 
		this.portaTcpa = clienteEdita.getPortaTcpa(); 
		this.portaTcpb = clienteEdita.getPortaTcpb(); 
		this.portaTcpc = clienteEdita.getPortaTcpc(); 
		this.portaTcpd = clienteEdita.getPortaTcpd(); 
		this.portaHttpa = clienteEdita.getPortaHttpa(); 
		this.portaHttpb = clienteEdita.getPortaHttpb(); 
		this.portaHttpc = clienteEdita.getPortaHttpc(); 
		this.portaHttpd = clienteEdita.getPortaHttpd(); 
	}    
    
}