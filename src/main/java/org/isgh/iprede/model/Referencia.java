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
@SequenceGenerator(name = "t_referencia_isn_referencia_seq", sequenceName = "t_referencia_isn_referencia_seq", allocationSize = 1)
@Table(name = "t_referencia")
public class Referencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_referencia_isn_referencia_seq")
	private Long isnReferencia;
	
	@NotNull(message = "O campo descrição é obrigatório")
    @Size(message = "O campo descrição deve ter no máximo 30 caracteres", min = 1, max = 30)
	private String dscReferencia;
	
	@NotNull(message = "O campo sigla é obrigatório")
    @Size(message = "O campo sigla deve ter no máximo 10 caracteres", min = 1, max = 10)
	private String sglReferencia;
	
	@NotNull(message = "O campo cep é obrigatório")
    @Size(message = "O campo cep é inválido", min = 8, max = 9)
	private String numCep;
	
	@Size(message = "O campo endereço deve ter no máximo 100 caracteres", max = 100)
	private String dscEndereco;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_bairro")
	private Bairro bairro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_cidade")
	private Cidade cidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_uf")
	private Uf uf;
	
	@Size(message = "O campo telefone deve ter no máximo 11 caracteres", max = 11)
	private String numTelefone;
	
	private String dscContato;
	
	private Boolean flgAtivo = true;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datCadastro = new Date();
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_usuario")
	private Usuario usuario;

	public Long getIsnReferencia() {
		return isnReferencia;
	}

	public void setIsnReferencia(Long isnReferencia) {
		this.isnReferencia = isnReferencia;
	}

	public String getDscReferencia() {
		return dscReferencia;
	}

	public void setDscReferencia(String dscReferencia) {
		this.dscReferencia = dscReferencia;
	}

	public String getSglReferencia() {
		return sglReferencia;
	}

	public void setSglReferencia(String sglReferencia) {
		this.sglReferencia = sglReferencia;
	}

	public String getNumCep() {
		return numCep;
	}

	public void setNumCep(String numCep) {
		this.numCep = numCep;
	}

	public String getDscEndereco() {
		return dscEndereco;
	}

	public void setDscEndereco(String dscEndereco) {
		this.dscEndereco = dscEndereco;
	}

	public String getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}

	public String getDscContato() {
		return dscContato;
	}

	public void setDscContato(String dscContato) {
		this.dscContato = dscContato;
	}

	public Date getDatCadastro() {
		return datCadastro;
	}

	public void setDatCadastro(Date datCadastro) {
		this.datCadastro = datCadastro;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "Referencia [" + (isnReferencia != null ? "isnReferencia=" + isnReferencia + ", " : "")
				+ (dscReferencia != null ? "dscReferencia=" + dscReferencia + ", " : "")
				+ (sglReferencia != null ? "sglReferencia=" + sglReferencia + ", " : "")
				+ (numCep != null ? "numCep=" + numCep + ", " : "")
				+ (dscEndereco != null ? "dscEndereco=" + dscEndereco + ", " : "")
				+ (bairro != null ? "bairro=" + bairro + ", " : "") + (cidade != null ? "cidade=" + cidade + ", " : "")
				+ (uf != null ? "uf=" + uf + ", " : "")
				+ (numTelefone != null ? "numTelefone=" + numTelefone + ", " : "")
				+ (dscContato != null ? "dscContato=" + dscContato + ", " : "")
				+ (flgAtivo != null ? "flgAtivo=" + flgAtivo + ", " : "")
				+ (datCadastro != null ? "datCadastro=" + datCadastro + ", " : "")
				+ (usuario != null ? "usuario=" + usuario : "") + "]";
	}

}
