package org.isgh.iprede.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonIdentityInfo;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@SequenceGenerator(name = "t_precadastro_isn_precadastro_seq", sequenceName = "t_precadastro_isn_precadastro_seq", allocationSize = 1)
@Table(name = "t_precadastro")
public class Precadastro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_precadastro_isn_precadastro_seq")
	private Long isnPrecadastro;
	
	@NotNull(message = "O campo nome é obrigatório")
    @Size(message = "O campo nome deve ter no máximo 100 caracteres", min = 1, max = 100)
	private String dscNome;
	
	@NotNull(message = "O campo sexo é obrigatório")
	private String codSexo;

	@NotNull(message = "O campo data de nascimento é obrigatório")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date datNascimento;
	
	private String dscNomeSocial;
	
	private Boolean flgCertidao;
	
	@NotNull(message = "O campo mãe é obrigatório")
    @Size(message = "O campo mãe deve ter no máximo 100 caracteres", min = 1, max = 100)
	private String dscMae;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date datNascimentoMae;
	
	@Size(message = "O campo cpf da mãe deve ter no máximo 11 caracteres", max = 11)
	private String numCpfMae;
	
	@Size(message = "O campo rg da mãe deve ter no máximo 15 caracteres", max = 15)
	private String numRgMae;
	
	@Size(message = "O campo telefone da mãe deve ter no máximo 11 caracteres", max = 11)
	private String numTelefoneMae;
	
	@Size(message = "O campo tipo de telefone da mãe deve ter no máximo 15 caracteres", max = 15)
	private String tipoTelefoneMae;
	
	@Size(message = "O campo nome do cuidador deve ter no máximo 100 caracteres", max = 100)
	private String dscNomeCuidador;

	private String codSexoCuidador;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_parentesco_cuidador")
	private Parentesco parentescoCuidador;
	
	@Size(message = "O campo cep do cuidador deve ter no máximo 9 caracteres", max = 9)
	private String numCepCuidador;
	
	@Size(message = "O campo endereço do cuidador deve ter no máximo 100 caracteres", max = 100)
	private String dscEnderecoCuidador;
	
	@Size(message = "O campo número do endereço do cuidador deve ter no máximo 10 caracteres", max = 10)
	private String numEnderecoCuidador;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_bairro_cuidador")
	private Bairro bairroCuidador;
	
	@JoinColumn(name = "isn_regional_cuidador")
	private Integer isnRegionalCuidador;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_cidade_cuidador")
	private Cidade cidadeCuidador;
	
	@Size(message = "O campo tipo de telefone do cuidador deve ter no máximo 15 caracteres", max = 15)
	private String tipoTelefoneCuidador;
	
	@Size(message = "O campo telefone do cuidador deve ter no máximo 11 caracteres", max = 11)
	private String numTelefoneCuidador;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_uf_cuidador")
	private Uf ufCuidador;
	
	@Size(message = "O campo motivo deve ter no máximo 300 caracteres", max = 300)
	private String dscMotivo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_referencia_origem")
	private Referencia referenciaOrigem;
	
	@Size(message = "O campo nome do profissional deve ter no máximo 150 caracteres", max = 150)
	private String dscProfissional;
	
	private Boolean flgDemandaEspontanea;
	
	@Size(message = "O campo avaliação deve ter no máximo 200 caracteres", max = 200)
	private String dscAvaliacao;
	
	private Boolean flgAdmitir;
	
	private Boolean flgEncaminhar;
	
	@Size(message = "O campo encaminhar deve ter no máximo 200 caracteres", max = 200)
	private String dscEncaminhar;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isn_referencia_destino")
	private Referencia referenciaDestino;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datCadastro;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "precadastro", fetch = FetchType.LAZY)
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@PrecadastroPrecadastropesos")
	private Set<Precadastropeso> listPrecadastropeso;
	
	private String flgDecisao;

	public Long getIsnPrecadastro() {
		return isnPrecadastro;
	}

	public void setIsnPrecadastro(Long isnPrecadastro) {
		this.isnPrecadastro = isnPrecadastro;
	}

	public String getDscNome() {
		return dscNome;
	}

	public void setDscNome(String dscNome) {
		this.dscNome = dscNome;
	}

	public String getCodSexo() {
		return codSexo;
	}

	public void setCodSexo(String codSexo) {
		this.codSexo = codSexo;
	}

	public Date getDatNascimento() {
		return datNascimento;
	}

	public void setDatNascimento(Date datNascimento) {
		this.datNascimento = datNascimento;
	}

	public String getDscNomeSocial() {
		return dscNomeSocial;
	}

	public void setDscNomeSocial(String dscNomeSocial) {
		this.dscNomeSocial = dscNomeSocial;
	}


	public void setFlgCertidao(Boolean flgCertidao) {
		this.flgCertidao = flgCertidao;
	}

	public String getDscMae() {
		return dscMae;
	}

	public void setDscMae(String dscMae) {
		this.dscMae = dscMae;
	}

	public Date getDatNascimentoMae() {
		return datNascimentoMae;
	}

	public void setDatNascimentoMae(Date datNascimentoMae) {
		this.datNascimentoMae = datNascimentoMae;
	}

	public String getNumCpfMae() {
		return numCpfMae;
	}

	public void setNumCpfMae(String numCpfMae) {
		this.numCpfMae = numCpfMae;
	}

	public String getNumRgMae() {
		return numRgMae;
	}

	public void setNumRgMae(String numRgMae) {
		this.numRgMae = numRgMae;
	}

	public String getNumTelefoneMae() {
		return numTelefoneMae;
	}

	public void setNumTelefoneMae(String numTelefoneMae) {
		this.numTelefoneMae = numTelefoneMae;
	}

	public String getTipoTelefoneMae() {
		return tipoTelefoneMae;
	}

	public void setTipoTelefoneMae(String tipoTelefoneMae) {
		this.tipoTelefoneMae = tipoTelefoneMae;
	}

	public String getDscNomeCuidador() {
		return dscNomeCuidador;
	}

	public void setDscNomeCuidador(String dscNomeCuidador) {
		this.dscNomeCuidador = dscNomeCuidador;
	}

	public String getCodSexoCuidador() {
		return codSexoCuidador;
	}

	public void setCodSexoCuidador(String codSexoCuidador) {
		this.codSexoCuidador = codSexoCuidador;
	}

	public String getNumCepCuidador() {
		return numCepCuidador;
	}

	public void setNumCepCuidador(String numCepCuidador) {
		this.numCepCuidador = numCepCuidador;
	}

	public String getDscEnderecoCuidador() {
		return dscEnderecoCuidador;
	}

	public void setDscEnderecoCuidador(String dscEnderecoCuidador) {
		this.dscEnderecoCuidador = dscEnderecoCuidador;
	}

	public String getNumEnderecoCuidador() {
		return numEnderecoCuidador;
	}

	public void setNumEnderecoCuidador(String numEnderecoCuidador) {
		this.numEnderecoCuidador = numEnderecoCuidador;
	}

	public String getTipoTelefoneCuidador() {
		return tipoTelefoneCuidador;
	}

	public void setTipoTelefoneCuidador(String tipoTelefoneCuidador) {
		this.tipoTelefoneCuidador = tipoTelefoneCuidador;
	}

	public String getNumTelefoneCuidador() {
		return numTelefoneCuidador;
	}

	public void setNumTelefoneCuidador(String numTelefoneCuidador) {
		this.numTelefoneCuidador = numTelefoneCuidador;
	}

	public String getDscMotivo() {
		return dscMotivo;
	}

	public void setDscMotivo(String dscMotivo) {
		this.dscMotivo = dscMotivo;
	}

	public String getDscProfissional() {
		return dscProfissional;
	}

	public void setDscProfissional(String dscProfissional) {
		this.dscProfissional = dscProfissional;
	}

	public String getDscAvaliacao() {
		return dscAvaliacao;
	}

	public void setDscAvaliacao(String dscAvaliacao) {
		this.dscAvaliacao = dscAvaliacao;
	}

	public Date getDatCadastro() {
		return datCadastro;
	}

	public void setDatCadastro(Date datCadastro) {
		this.datCadastro = datCadastro;
	}

	public Parentesco getParentescoCuidador() {
		return parentescoCuidador;
	}

	public void setParentescoCuidador(Parentesco parentescoCuidador) {
		this.parentescoCuidador = parentescoCuidador;
	}

	public Bairro getBairroCuidador() {
		return bairroCuidador;
	}

	public void setBairroCuidador(Bairro bairroCuidador) {
		this.bairroCuidador = bairroCuidador;
	}

	public Cidade getCidadeCuidador() {
		return cidadeCuidador;
	}

	public void setCidadeCuidador(Cidade cidadeCuidador) {
		this.cidadeCuidador = cidadeCuidador;
	}

	public Uf getUfCuidador() {
		return ufCuidador;
	}

	public void setUfCuidador(Uf ufCuidador) {
		this.ufCuidador = ufCuidador;
	}

	public Referencia getReferenciaOrigem() {
		return referenciaOrigem;
	}

	public void setReferenciaOrigem(Referencia referenciaOrigem) {
		this.referenciaOrigem = referenciaOrigem;
	}

	public Referencia getReferenciaDestino() {
		return referenciaDestino;
	}

	public void setReferenciaDestino(Referencia referenciaDestino) {
		this.referenciaDestino = referenciaDestino;
	}

	//@JsonBackReference
	public Set<Precadastropeso> getListPrecadastropeso() {
		return listPrecadastropeso;
	}

	public void setListPrecadastropeso(Set<Precadastropeso> listPrecadastropeso) {
		this.listPrecadastropeso = listPrecadastropeso;
	}

	public Boolean getFlgDemandaEspontanea() {
		return flgDemandaEspontanea;
	}

	public void setFlgDemandaEspontanea(Boolean flgDemandaEspontanea) {
		this.flgDemandaEspontanea = flgDemandaEspontanea;
	}

	public Boolean getFlgAdmitir() {
		return flgAdmitir;
	}

	public void setFlgAdmitir(Boolean flgAdmitir) {
		this.flgAdmitir = flgAdmitir;
	}

	public Boolean getFlgEncaminhar() {
		return flgEncaminhar;
	}

	public void setFlgEncaminhar(Boolean flgEncaminhar) {
		this.flgEncaminhar = flgEncaminhar;
	}

	public String getDscEncaminhar() {
		return dscEncaminhar;
	}

	public void setDscEncaminhar(String dscEncaminhar) {
		this.dscEncaminhar = dscEncaminhar;
	}

	public Boolean getFlgCertidao() {
		return flgCertidao;
	}

	public Integer getIsnRegionalCuidador() {
		return isnRegionalCuidador;
	}

	public void setIsnRegionalCuidador(Integer isnRegionalCuidador) {
		this.isnRegionalCuidador = isnRegionalCuidador;
	}

	public String getFlgDecisao() {
		return flgDecisao;
	}

	public void setFlgDecisao(String flgDecisao) {
		this.flgDecisao = flgDecisao;
	}

	@Override
	public String toString() {
		return "Precadastro [" + (isnPrecadastro != null ? "isnPrecadastro=" + isnPrecadastro + ", " : "")
				+ (dscNome != null ? "dscNome=" + dscNome + ", " : "")
				+ (codSexo != null ? "codSexo=" + codSexo + ", " : "")
				+ (datNascimento != null ? "datNascimento=" + datNascimento + ", " : "")
				+ (dscNomeSocial != null ? "dscNomeSocial=" + dscNomeSocial + ", " : "")
				+ (flgCertidao != null ? "flgCertidao=" + flgCertidao + ", " : "")
				+ (dscMae != null ? "dscMae=" + dscMae + ", " : "")
				+ (datNascimentoMae != null ? "datNascimentoMae=" + datNascimentoMae + ", " : "")
				+ (numCpfMae != null ? "numCpfMae=" + numCpfMae + ", " : "")
				+ (numRgMae != null ? "numRgMae=" + numRgMae + ", " : "")
				+ (numTelefoneMae != null ? "numTelefoneMae=" + numTelefoneMae + ", " : "")
				+ (tipoTelefoneMae != null ? "tipoTelefoneMae=" + tipoTelefoneMae + ", " : "")
				+ (dscNomeCuidador != null ? "dscNomeCuidador=" + dscNomeCuidador + ", " : "")
				+ (codSexoCuidador != null ? "codSexoCuidador=" + codSexoCuidador + ", " : "")
				+ (parentescoCuidador != null ? "parentescoCuidador=" + parentescoCuidador + ", " : "")
				+ (numCepCuidador != null ? "numCepCuidador=" + numCepCuidador + ", " : "")
				+ (dscEnderecoCuidador != null ? "dscEnderecoCuidador=" + dscEnderecoCuidador + ", " : "")
				+ (numEnderecoCuidador != null ? "numEnderecoCuidador=" + numEnderecoCuidador + ", " : "")
				+ (bairroCuidador != null ? "bairroCuidador=" + bairroCuidador + ", " : "")
				+ (isnRegionalCuidador != null ? "isnRegionalCuidador=" + isnRegionalCuidador + ", " : "")
				+ (cidadeCuidador != null ? "cidadeCuidador=" + cidadeCuidador + ", " : "")
				+ (tipoTelefoneCuidador != null ? "tipoTelefoneCuidador=" + tipoTelefoneCuidador + ", " : "")
				+ (numTelefoneCuidador != null ? "numTelefoneCuidador=" + numTelefoneCuidador + ", " : "")
				+ (ufCuidador != null ? "ufCuidador=" + ufCuidador + ", " : "")
				+ (dscMotivo != null ? "dscMotivo=" + dscMotivo + ", " : "")
				+ (referenciaOrigem != null ? "referenciaOrigem=" + referenciaOrigem + ", " : "")
				+ (dscProfissional != null ? "dscProfissional=" + dscProfissional + ", " : "")
				+ (flgDemandaEspontanea != null ? "flgDemandaEspontanea=" + flgDemandaEspontanea + ", " : "")
				+ (dscAvaliacao != null ? "dscAvaliacao=" + dscAvaliacao + ", " : "")
				+ (flgAdmitir != null ? "flgAdmitir=" + flgAdmitir + ", " : "")
				+ (flgEncaminhar != null ? "flgEncaminhar=" + flgEncaminhar + ", " : "")
				+ (dscEncaminhar != null ? "dscEncaminhar=" + dscEncaminhar + ", " : "")
				+ (referenciaDestino != null ? "referenciaDestino=" + referenciaDestino + ", " : "")
				+ (datCadastro != null ? "datCadastro=" + datCadastro + ", " : "")
				+ (listPrecadastropeso != null ? "listPrecadastropeso=" + listPrecadastropeso : "") + "]";
	}
	
}
