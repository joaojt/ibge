package dev.joaojt.ibge.consorcio.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.joaojt.ibge.consorcio.domain.Consorcio;

public interface ConsorcioRepositoryJpa extends JpaRepository<Consorcio, Integer>{

}