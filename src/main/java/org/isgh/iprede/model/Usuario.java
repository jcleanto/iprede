package org.isgh.iprede.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
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

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name = "t_usuario_isn_usuario_seq", sequenceName = "t_usuario_isn_usuario_seq", allocationSize = 1)
@Table(name = "t_usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_usuario_isn_usuario_seq")
	private Long isnUsuario;
	
	@NotNull(message = "O campo descrição é obrigatório")
    @Size(message = "O campo descrição deve ter no máximo 100 caracteres", min = 1, max = 100)
	private String dscUsuario;
	
	@NotNull(message = "O campo email é obrigatório")
	@Email(message = "O campo email deve ser válido")
	private String dscEmail;
	
	@JsonIgnore
	private String dscSenha;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datCadastro;
	
	/*@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_usuariocad")
	private Usuario usuariocad;*/
	
	private Boolean flgAtivo;
	
	private Boolean flgEmailvalidado;
	
	@ManyToOne
	@JoinColumn(name = "isn_usuario_tipo")
	private UsuarioTipo usuarioTipo;

	public Long getIsnUsuario() {
		return isnUsuario;
	}

	public void setIsnUsuario(Long isnUsuario) {
		this.isnUsuario = isnUsuario;
	}

	public String getDscUsuario() {
		return dscUsuario;
	}

	public void setDscUsuario(String dscUsuario) {
		this.dscUsuario = dscUsuario;
	}

	public String getDscEmail() {
		return dscEmail;
	}

	public void setDscEmail(String dscEmail) {
		this.dscEmail = dscEmail;
	}

	public String getDscSenha() {
		return dscSenha;
	}

	public void setDscSenha(String dscSenha) {
		this.dscSenha = dscSenha;
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

	public Boolean isFlgEmailvalidado() {
		return flgEmailvalidado;
	}

	public void setFlgEmailvalidado(Boolean flgEmailvalidado) {
		this.flgEmailvalidado = flgEmailvalidado;
	}

	/*public Usuario getUsuariocad() {
		return usuariocad;
	}

	public void setUsuariocad(Usuario usuariocad) {
		this.usuariocad = usuariocad;
	}*/

	public UsuarioTipo getUsuarioTipo() {
		return usuarioTipo;
	}

	public void setUsuarioTipo(UsuarioTipo usuarioTipo) {
		this.usuarioTipo = usuarioTipo;
	}

	public Boolean getFlgAtivo() {
		return flgAtivo;
	}

	public Boolean getFlgEmailvalidado() {
		return flgEmailvalidado;
	}

	@Override
	public String toString() {
		return "Usuario [" + (isnUsuario != null ? "isnUsuario=" + isnUsuario + ", " : "")
				+ (dscUsuario != null ? "dscUsuario=" + dscUsuario + ", " : "")
				+ (dscEmail != null ? "dscEmail=" + dscEmail + ", " : "")
				+ (dscSenha != null ? "dscSenha=" + dscSenha + ", " : "")
				+ (datCadastro != null ? "datCadastro=" + datCadastro + ", " : "")
//				+ (usuariocad != null ? "usuariocad=" + usuariocad + ", " : "")
				+ (flgAtivo != null ? "flgAtivo=" + flgAtivo + ", " : "")
				+ (flgEmailvalidado != null ? "flgEmailvalidado=" + flgEmailvalidado + ", " : "")
				+ (usuarioTipo != null ? "usuarioTipo=" + usuarioTipo : "") + "]";
	}

}
