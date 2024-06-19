package dev.joaojt.ibge.servidor.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.joaojt.ibge.servidor.domain.Servidor;

public interface ServidorRepositoryJpa extends JpaRepository<Servidor, Integer>{

}