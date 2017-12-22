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
@SequenceGenerator(name = "t_bairro_isn_bairro_seq", sequenceName = "t_bairro_isn_bairro_seq", allocationSize = 1)
@Table(name = "t_bairro")
public class Bairro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_bairro_isn_bairro_seq")
	private Long isnBairro;
	
	@NotNull(message = "O campo descrição é obrigatório")
    @Size(message = "O campo descrição deve ter no máximo 70 caracteres", min = 1, max = 70)
	private String dscBairro;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_regional")
	private Regional regional;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "isn_cidade")
	private Cidade cidade;
	
	private Boolean flgAtivo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datCadastro;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_usuario")
	private Usuario usuario;

	public Long getIsnBairro() {
		return isnBairro;
	}

	public void setIsnBairro(Long isnBairro) {
		this.isnBairro = isnBairro;
	}

	public String getDscBairro() {
		return dscBairro;
	}

	public void setDscBairro(String dscBairro) {
		this.dscBairro = dscBairro;
	}

	public Date getDatCadastro() {
		return datCadastro;
	}

	public void setDatCadastro(Date datCadastro) {
		this.datCadastro = datCadastro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Regional getRegional() {
		return regional;
	}

	public void setRegional(Regional regional) {
		this.regional = regional;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getFlgAtivo() {
		return flgAtivo;
	}

	public void setFlgAtivo(Boolean flgAtivo) {
		this.flgAtivo = flgAtivo;
	}

	@Override
	public String toString() {
		return "Bairro [" + (isnBairro != null ? "isnBairro=" + isnBairro + ", " : "")
				+ (dscBairro != null ? "dscBairro=" + dscBairro + ", " : "")
				+ (regional != null ? "regional=" + regional + ", " : "")
				+ (cidade != null ? "cidade=" + cidade + ", " : "")
				+ (flgAtivo != null ? "flgAtivo=" + flgAtivo + ", " : "")
				+ (datCadastro != null ? "datCadastro=" + datCadastro + ", " : "")
				+ (usuario != null ? "usuario=" + usuario : "") + "]";
	}

}
