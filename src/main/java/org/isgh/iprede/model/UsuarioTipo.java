package org.isgh.iprede.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "t_usuario_tipo_isn_usuario_tipo_seq", sequenceName = "t_usuario_tipo_isn_usuario_tipo_seq", allocationSize = 1)
@Table(name = "t_usuario_tipo")
public class UsuarioTipo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_usuario_tipo_isn_usuario_tipo_seq")
	private Long isnUsuarioTipo;
	
	private String dscUsuarioTipo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datCadastro;
	
	/*@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_usuario")
	private Usuario usuario;*/
	
	private Boolean flgAtivo;

	public Long getIsnUsuarioTipo() {
		return isnUsuarioTipo;
	}

	public void setIsnUsuarioTipo(Long isnUsuarioTipo) {
		this.isnUsuarioTipo = isnUsuarioTipo;
	}

	public String getDscUsuarioTipo() {
		return dscUsuarioTipo;
	}

	public void setDscUsuarioTipo(String dscUsuarioTipo) {
		this.dscUsuarioTipo = dscUsuarioTipo;
	}

	public Date getDatCadastro() {
		return datCadastro;
	}

	public void setDatCadastro(Date datCadastro) {
		this.datCadastro = datCadastro;
	}

	/*public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}*/

	public Boolean isFlgAtivo() {
		return flgAtivo;
	}

	public void setFlgAtivo(Boolean flgAtivo) {
		this.flgAtivo = flgAtivo;
	}

	@Override
	public String toString() {
		return "UsuarioTipo [" + (isnUsuarioTipo != null ? "isnUsuarioTipo=" + isnUsuarioTipo + ", " : "")
				+ (dscUsuarioTipo != null ? "dscUsuarioTipo=" + dscUsuarioTipo + ", " : "")
				+ (datCadastro != null ? "datCadastro=" + datCadastro + ", " : "")
	//			+ (usuario != null ? "usuario=" + usuario + ", " : "")
				+ (flgAtivo != null ? "flgAtivo=" + flgAtivo : "") + "]";
	}

}
