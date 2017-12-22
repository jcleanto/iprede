package org.isgh.iprede.repository;

import java.util.List;

import org.isgh.iprede.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Usuarios extends PagingAndSortingRepository<Usuario, Long> {

	@Query("select u from Usuario u where u.dscUsuario like %?1%")
	List<Usuario> findUsuariosByName(String dscUsuario);
	
	@Query("select u from Usuario u where u.isnUsuario = ?1")
	Usuario findUsuarioById(long isnUsuario);
	
	@Query("select u from Usuario u where u.dscEmail = ?1")
	Usuario findUsuarioByEmail(String email);

}
