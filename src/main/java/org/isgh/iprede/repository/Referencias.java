package org.isgh.iprede.repository;

import java.util.List;

import org.isgh.iprede.model.Referencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Referencias extends PagingAndSortingRepository<Referencia, Long>{
	
	@Query("select r from Referencia r join fetch r.bairro b join fetch r.cidade c join fetch r.uf u where upper(r.dscReferencia) like %?1% or upper(r.sglReferencia) like %?1%")
	List<Referencia> findByDscReferenciaOrSglReferencia(String dscReferencia);
	
	@Query("select r from Referencia r join fetch r.bairro b join fetch r.cidade c join fetch r.uf u")
	List<Referencia> findReferencias();
	
	@Query("select r from Referencia r join fetch r.bairro b join fetch r.cidade c join fetch r.uf u where r.isnReferencia = ?1")
	Referencia findById(long isnReferencia);

}
