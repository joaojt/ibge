package dev.joaojt.ibge.cliente.infra;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.joaojt.ibge.cliente.domain.Cliente;

public interface ClienteRepositoryJpa extends JpaRepository<Cliente, Integer>{
	
	Optional<Cliente> findFirstByClienteTipoId(Integer clienteTipoId);

	Optional<Cliente> findFirstByConsorcioId(Integer consorcioId);

	Optional<Cliente> findFirstByServidorPortaIdOrServidorBancoId(Integer servidorPortaId, Integer servidorBancoId);
	
//	  JPQL:
//    @Query("select c from Cliente c where cast(c.ibge as string) like %:clienteIbge%")
//    List<Cliente> buscaClientesPorIbge(@Param("clienteIbge") String clienteIbge);
//    
//    @Query("select c from Cliente c where c.descricao like %:clienteDescricao%")
//    List<Cliente> buscaClientesPorDescricao(@Param("clienteDescricao") String clienteDescricao);
	
    @Query(value = "select * from cliente where cast(ibge as varchar(7)) like %:clienteIbge%", nativeQuery = true)
    List<Cliente> buscaClientesPorIbge(@Param("clienteIbge") String clienteIbge);

    @Query(value = "select * from cliente where descricao like %:clienteDescricao%", nativeQuery = true)
    List<Cliente> buscaClientesPorDescricao(@Param("clienteDescricao") String clienteDescricao);	

}