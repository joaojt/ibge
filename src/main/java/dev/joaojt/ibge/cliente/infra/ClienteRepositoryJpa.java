package dev.joaojt.ibge.cliente.infra;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.joaojt.ibge.cliente.domain.Cliente;

public interface ClienteRepositoryJpa extends JpaRepository<Cliente, Integer>{
	
	Optional<Cliente> findFirstByClienteTipoId(Integer clienteTipoId);

	Optional<Cliente> findFirstByConsorcioId(Integer consorcioId);

	Optional<Cliente> findFirstByServidorPortaIdOrServidorBancoId(Integer servidorPortaId, Integer servidorBancoId);

}