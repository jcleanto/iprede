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
@SequenceGenerator(name = "t_regional_isn_regional_seq", sequenceName = "t_regional_isn_regional_seq", allocationSize = 1)
@Table(name = "t_regional")
public class Regional implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_regional_isn_regional_seq")
	private Long isnRegional;
	
	@NotNull(message = "O campo regional é obrigatório")
    @Size(message = "O campo regional deve ter no máximo 30 caracteres", min = 1, max = 30)
	private String dscRegional;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datCadastro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_cidade")
	private Cidade cidade;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_usuario")
	private Usuario usuario;
	
	private Boolean flgAtivo;

	public Long getIsnRegional() {
		return isnRegional;
	}

	public void setIsnRegional(Long isnRegional) {
		this.isnRegional = isnRegional;
	}

	public String getDscRegional() {
		return dscRegional;
	}

	public void setDscRegional(String dscRegional) {
		this.dscRegional = dscRegional;
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Regional [" + (isnRegional != null ? "isnRegional=" + isnRegional + ", " : "")
				+ (dscRegional != null ? "dscRegional=" + dscRegional + ", " : "")
				+ (datCadastro != null ? "datCadastro=" + datCadastro + ", " : "")
				+ (cidade != null ? "cidade=" + cidade + ", " : "")
				+ (usuario != null ? "usuario=" + usuario + ", " : "")
				+ (flgAtivo != null ? "flgAtivo=" + flgAtivo : "") + "]";
	}

}
