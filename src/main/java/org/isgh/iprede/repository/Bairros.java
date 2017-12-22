package org.isgh.iprede.repository;

import java.util.List;

import org.isgh.iprede.model.Bairro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Bairros extends PagingAndSortingRepository<Bairro, Long> {

	@Query("select b from Bairro b where b.cidade.isnCidade = ?1")
	List<Bairro> findAllByCidade(Long isnCidade);
}
