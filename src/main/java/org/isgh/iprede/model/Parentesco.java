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
@SequenceGenerator(name = "t_parentesco_isn_parentesco_seq", sequenceName = "t_parentesco_isn_parentesco_seq", allocationSize = 1)
@Table(name = "t_parentesco")
public class Parentesco implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_parentesco_isn_parentesco_seq")
	private Long isnParentesco;
	
	@NotNull(message = "O campo descrição é obrigatório")
    @Size(message = "O campo descrição deve ter no máximo 30 caracteres", min = 1, max = 30)
	private String dscParentesco;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datCadastro;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_usuario")
	private Usuario usuario;
	
	private Boolean flgAtivo;

	public Long getIsnParentesco() {
		return isnParentesco;
	}

	public void setIsnParentesco(Long isnParentesco) {
		this.isnParentesco = isnParentesco;
	}

	public String getDscParentesco() {
		return dscParentesco;
	}

	public void setDscParentesco(String dscParentesco) {
		this.dscParentesco = dscParentesco;
	}

	public Date getDatCadastro() {
		return datCadastro;
	}

	public void setDatCadastro(Date datCadastro) {
		this.datCadastro = datCadastro;
	}

	public Boolean getFlgAtivo() {
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
		return "Parentesco [" + (isnParentesco != null ? "isnParentesco=" + isnParentesco + ", " : "")
				+ (dscParentesco != null ? "dscParentesco=" + dscParentesco + ", " : "")
				+ (datCadastro != null ? "datCadastro=" + datCadastro + ", " : "")
				+ (usuario != null ? "usuario=" + usuario + ", " : "")
				+ (flgAtivo != null ? "flgAtivo=" + flgAtivo : "") + "]";
	}

}
