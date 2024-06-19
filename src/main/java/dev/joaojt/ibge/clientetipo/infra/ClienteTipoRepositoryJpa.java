package dev.joaojt.ibge.clientetipo.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.joaojt.ibge.clientetipo.domain.ClienteTipo;

public interface ClienteTipoRepositoryJpa extends JpaRepository<ClienteTipo, Integer>{
	
}