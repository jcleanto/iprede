package org.isgh.iprede.repository;

import java.util.List;

import org.isgh.iprede.model.UsuarioTipo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioTipos extends PagingAndSortingRepository<UsuarioTipo, Long> {
	
	@Query("select ut from UsuarioTipo ut where ut.flgAtivo = ?1")
	List<UsuarioTipo> findUsuarioTiposByFlgAtivo(boolean flgAtivo);
	
	@Query("select ut from UsuarioTipo ut where ut.dscUsuarioTipo = ?1")
	UsuarioTipo findUsuarioTipoByTipo(String tipo);

}
