package org.isgh.iprede.repository;

import java.util.List;

import org.isgh.iprede.model.Precadastro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Precadastros extends PagingAndSortingRepository<Precadastro, Long> {

	@Query("select pc from Precadastro pc where upper(pc.dscNome) like %?1% or upper(pc.dscNomeSocial) like %?1%")
	List<Precadastro> findByDscnomeOrDscNomeSocial(String dscNome);
	
	@Query("select pc from Precadastro pc inner join pc.listPrecadastropeso pcp where (upper(pc.dscNome) like %?1% or upper(pc.dscNomeSocial) like %?1%) and to_char(pc.datCadastro,'YYYY/MM/DD') = to_char(now(),'YYYY/MM/DD') and pc.dscAvaliacao is null")
	List<Precadastro> findWithPrecadastropeso(String dscNome);
	
	@Query("select pc from Precadastro pc join fetch pc.listPrecadastropeso pcp join fetch pc.referenciaOrigem ro join fetch pc.parentescoCuidador pcui join fetch pc.bairroCuidador bcui join fetch pc.cidadeCuidador ccui left join pc.referenciaDestino rd where to_char(pc.datCadastro,'YYYY/MM/DD') = to_char(now(),'YYYY/MM/DD') and pc.dscAvaliacao is null")
	List<Precadastro> findAllWithPrecadastropeso();
	
	@Query("select pc from Precadastro pc left join pc.listPrecadastropeso pcp join fetch pc.referenciaOrigem ro join fetch pc.parentescoCuidador pcui join fetch pc.bairroCuidador bcui join fetch pc.cidadeCuidador ccui left join pc.referenciaDestino rd where (upper(pc.dscNome) like %?1% or upper(pc.dscNomeSocial) like %?1%) and pcp.isnPrecadastropeso is null and to_char(pc.datCadastro,'YYYY/MM/DD') = to_char(now(),'YYYY/MM/DD')")
	List<Precadastro> findWithoutPrecadastropeso(String dscNome);
	
	@Query("select pc from Precadastro pc left join pc.listPrecadastropeso pcp inner join fetch pc.referenciaOrigem ro inner join fetch pc.parentescoCuidador pcui inner join fetch pc.bairroCuidador bcui inner join fetch pc.cidadeCuidador ccui left join pc.referenciaDestino rd where pcp.isnPrecadastropeso is null and to_char(pc.datCadastro,'YYYY/MM/DD') = to_char(now(),'YYYY/MM/DD')")
	List<Precadastro> findAllWithoutPrecadastropeso();
	
	@Query("select pc from Precadastro pc join fetch pc.listPrecadastropeso pcp join fetch pc.referenciaOrigem ro join fetch pc.parentescoCuidador pcui join fetch pc.bairroCuidador bcui join fetch pc.cidadeCuidador ccui left join pc.referenciaDestino rd where to_char(pc.datCadastro,'YYYY/MM/DD') = to_char(now(),'YYYY/MM/DD') and pcp.numWhoanthro between -1 and 1 and (pc.flgDecisao is null or pc.flgDecisao <> 'E')")
	List<Precadastro> findAcceptedWhoAnthro();
	
	@Query("select pc from Precadastro pc join fetch pc.listPrecadastropeso pcp join fetch pc.referenciaOrigem ro join fetch pc.parentescoCuidador pcui join fetch pc.bairroCuidador bcui join fetch pc.cidadeCuidador ccui left join pc.referenciaDestino rd where to_char(pc.datCadastro,'YYYY/MM/DD') = to_char(now(),'YYYY/MM/DD') and (pcp.numWhoanthro < -1 or pcp.numWhoanthro > 1) and (pc.flgDecisao is null or pc.flgDecisao <> 'E')")
	List<Precadastro> findRejectedWhoAnthro();
		
	@Query("select pc from Precadastro pc join fetch pc.listPrecadastropeso pcp join fetch pc.referenciaOrigem ro join fetch pc.parentescoCuidador pcui join fetch pc.bairroCuidador bcui join fetch pc.cidadeCuidador ccui left join fetch pc.referenciaDestino rd where to_char(pc.datCadastro,'YYYY/MM/DD') = to_char(now(),'YYYY/MM/DD') and pc.flgDecisao = 'E'")
	List<Precadastro> findForwarded();
	
	@Query("select pc from Precadastro pc join fetch pc.referenciaOrigem ro join fetch pc.parentescoCuidador pcui join fetch pc.bairroCuidador bcui join fetch pc.cidadeCuidador ccui join fetch pc.ufCuidador ucui left join pc.referenciaDestino rd where pc.isnPrecadastro = ?1")
	Precadastro findPrecadastroById(long isnPrecadastro);

}
