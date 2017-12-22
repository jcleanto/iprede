package org.isgh.iprede.repository;

import java.util.List;

import org.isgh.iprede.model.Parentesco;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Parentescos extends PagingAndSortingRepository<Parentesco, Long> {

	@Query("select p from Parentesco p where p.flgAtivo = ?1")
	List<Parentesco> findParentescosByFlgAtivo(boolean flgAtivo);

}
