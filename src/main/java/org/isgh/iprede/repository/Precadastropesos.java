package org.isgh.iprede.repository;

import java.util.List;

import org.isgh.iprede.model.Precadastropeso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Precadastropesos extends PagingAndSortingRepository<Precadastropeso, Long> {
	
	@Query("select pcp from Precadastropeso pcp where pcp.precadastro.isnPrecadastro = ?1")
	List<Precadastropeso> findAllByPrecadastro(Long isnPrecadastro);

}
