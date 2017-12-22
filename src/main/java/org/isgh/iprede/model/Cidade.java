package org.isgh.iprede.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@SequenceGenerator(name = "t_cidade_isn_cidade_seq", sequenceName = "t_cidade_isn_cidade_seq", allocationSize = 1)
@Table(name = "t_cidade")
public class Cidade implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_cidade_isn_cidade_seq")
	private Long isnCidade;
	
	@NotNull(message = "O campo descrição é obrigatório")
    @Size(message = "O campo descrição deve ter no máximo 70 caracteres", min = 1, max = 70)
	private String dscCidade;
	
	private Long isnUf;
	
	private Boolean flgAtivo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datCadastro;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_usuario")
	private Usuario usuario;

	public Long getIsnCidade() {
		return isnCidade;
	}

	public void setIsnCidade(Long isnCidade) {
		this.isnCidade = isnCidade;
	}

	public String getDscCidade() {
		return dscCidade;
	}

	public void setDscCidade(String dscCidade) {
		this.dscCidade = dscCidade;
	}

	public Long getIsnUf() {
		return isnUf;
	}

	public void setIsnUf(Long isnUf) {
		this.isnUf = isnUf;
	}

	public Boolean getFlgAtivo() {
		return flgAtivo;
	}
	
	public void setFlgAtivo(Boolean flgAtivo) {
		this.flgAtivo = flgAtivo;
	}

	public Date getDatCadastro() {
		return datCadastro;
	}

	public void setDatCadastro(Date datCadastro) {
		this.datCadastro = datCadastro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Cidade [" + (isnCidade != null ? "isnCidade=" + isnCidade + ", " : "")
				+ (dscCidade != null ? "dscCidade=" + dscCidade + ", " : "")
				+ (isnUf != null ? "isnUf=" + isnUf + ", " : "")
				+ (flgAtivo != null ? "flgAtivo=" + flgAtivo + ", " : "")
				+ (datCadastro != null ? "datCadastro=" + datCadastro + ", " : "")
				+ (usuario != null ? "usuario=" + usuario : "") + "]";
	}

}
