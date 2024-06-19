package dev.joaojt.ibge.cliente.domain;

import java.util.Optional;

import dev.joaojt.ibge.cliente.application.api.ClienteNovoRequest;
import dev.joaojt.ibge.clientetipo.domain.ClienteTipo;
import dev.joaojt.ibge.consorcio.domain.Consorcio;
import dev.joaojt.ibge.servidor.domain.Servidor;
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
    private Integer portaTcpA;
    private Integer portaTcpB;
    private Integer portaTcpC;
    private Integer portaTcpD;
    private Integer portaHttpA;
    private Integer portaHttpB;
    private Integer portaHttpC;
    private Integer portaHttpD;
    
	public Cliente(ClienteNovoRequest clienteNovo, Servidor servidorPorta, Servidor servidorBanco, Consorcio consorcio,	ClienteTipo clienteTipo) {
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
		Optional.ofNullable(clienteNovo.getPortaTcpA()).ifPresent(portaTcpA -> this.portaTcpA = portaTcpA);
		Optional.ofNullable(clienteNovo.getPortaTcpB()).ifPresent(portaTcpB -> this.portaTcpB = portaTcpB);
		Optional.ofNullable(clienteNovo.getPortaTcpC()).ifPresent(portaTcpC -> this.portaTcpC = portaTcpC);
		Optional.ofNullable(clienteNovo.getPortaTcpD()).ifPresent(portaTcpD -> this.portaTcpD = portaTcpD);
		Optional.ofNullable(clienteNovo.getPortaHttpA()).ifPresent(portaHttpA -> this.portaHttpA = portaHttpA);
		Optional.ofNullable(clienteNovo.getPortaHttpB()).ifPresent(portaHttpB -> this.portaHttpB = portaHttpB);
		Optional.ofNullable(clienteNovo.getPortaHttpC()).ifPresent(portaHttpC -> this.portaHttpC = portaHttpC);
		Optional.ofNullable(clienteNovo.getPortaHttpD()).ifPresent(portaHttpD -> this.portaHttpD = portaHttpD);
	}    
    
}