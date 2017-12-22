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
@SequenceGenerator(name = "t_uf_isn_uf_seq", sequenceName = "t_uf_isn_uf_seq", allocationSize = 1)
@Table(name = "t_uf")
public class Uf implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_uf_isn_uf_seq")
	private Long isnUf;
	
	@NotNull(message = "O campo descrição é obrigatório")
    @Size(message = "O campo descrição deve ter no máximo 70 caracteres", min = 1, max = 70)
	private String dscUf;
	
	private String sglUf;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datCadastro;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_usuario")
	private Usuario usuario;
	
	private Boolean flgAtivo;

	public Long getIsnUf() {
		return isnUf;
	}

	public void setIsnUf(Long isnUf) {
		this.isnUf = isnUf;
	}

	public String getDscUf() {
		return dscUf;
	}

	public void setDscUf(String dscUf) {
		this.dscUf = dscUf;
	}

	public String getSglUf() {
		return sglUf;
	}

	public void setSglUf(String sglUf) {
		this.sglUf = sglUf;
	}

	public Date getDatCadastro() {
		return datCadastro;
	}

	public void setDatCadastro(Date datCadastro) {
		this.datCadastro = datCadastro;
	}

	public Boolean isFlgAtivo() {
		return flgAtivo;
	}

	public void setFlgAtivo(Boolean flgAtivo) {
		this.flgAtivo = flgAtivo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Uf [" + (isnUf != null ? "isnUf=" + isnUf + ", " : "") + (dscUf != null ? "dscUf=" + dscUf + ", " : "")
				+ (sglUf != null ? "sglUf=" + sglUf + ", " : "")
				+ (datCadastro != null ? "datCadastro=" + datCadastro + ", " : "")
				+ (usuario != null ? "usuario=" + usuario + ", " : "")
				+ (flgAtivo != null ? "flgAtivo=" + flgAtivo : "") + "]";
	}

}
