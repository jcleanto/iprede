package org.isgh.iprede.repository;

import java.util.List;

import org.isgh.iprede.model.Regional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Regionais extends PagingAndSortingRepository<Regional, Long> {

	@Query("select r from Regional r where r.cidade.isnCidade = ?1")
	List<Regional> findAllByCidade(Long isnCidade);

}
