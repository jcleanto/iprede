package org.isgh.iprede.repository;

import java.util.List;

import org.isgh.iprede.model.Cidade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Cidades extends PagingAndSortingRepository<Cidade, Long> {
	
	@Query("select c from Cidade c where c.isnUf = ?1")
	List<Cidade> findAllByUf(Long isnUf);

}
