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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@SequenceGenerator(name = "t_precadastropeso_isn_precadastropeso_seq", sequenceName = "t_precadastropeso_isn_precadastropeso_seq", allocationSize = 1)
@Table(name = "t_precadastropeso")
public class Precadastropeso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_precadastropeso_isn_precadastropeso_seq")
	private Long isnPrecadastropeso;

	//@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_precadastro")
	private Precadastro precadastro;
	
	@NotNull(message = "O campo peso é obrigatório")
	private Double numPeso;
	
	@NotNull(message = "O campo altura é obrigatório")
	private Double numAltura;
	
	@NotNull(message = "O campo whoanthro é obrigatório")
	private Double numWhoanthro;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datCadastro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_usuario")
	private Usuario usuario;

	public Long getIsnPrecadastropeso() {
		return isnPrecadastropeso;
	}

	public void setIsnPrecadastropeso(Long isnPrecadastropeso) {
		this.isnPrecadastropeso = isnPrecadastropeso;
	}

	public Double getNumPeso() {
		return numPeso;
	}

	public void setNumPeso(Double numPeso) {
		this.numPeso = numPeso;
	}

	public Double getNumAltura() {
		return numAltura;
	}

	public void setNumAltura(Double numAltura) {
		this.numAltura = numAltura;
	}

	public Double getNumWhoanthro() {
		return numWhoanthro;
	}

	public void setNumWhoanthro(Double numWhoanthro) {
		this.numWhoanthro = numWhoanthro;
	}

	public Date getDatCadastro() {
		return datCadastro;
	}

	public void setDatCadastro(Date datCadastro) {
		this.datCadastro = datCadastro;
	}

	public Precadastro getPrecadastro() {
		return precadastro;
	}

	public void setPrecadastro(Precadastro precadastro) {
		this.precadastro = precadastro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Precadastropeso ["
				+ (isnPrecadastropeso != null ? "isnPrecadastropeso=" + isnPrecadastropeso + ", " : "")
				+ (precadastro != null ? "precadastro=" + precadastro + ", " : "")
				+ (numPeso != null ? "numPeso=" + numPeso + ", " : "")
				+ (numAltura != null ? "numAltura=" + numAltura + ", " : "")
				+ (numWhoanthro != null ? "numWhoanthro=" + numWhoanthro + ", " : "")
				+ (datCadastro != null ? "datCadastro=" + datCadastro + ", " : "")
				+ (usuario != null ? "usuario=" + usuario : "") + "]";
	}

}
