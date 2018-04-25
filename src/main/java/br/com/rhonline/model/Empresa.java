package br.com.rhonline.model;
/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

import static org.hibernate.annotations.CascadeType.LOCK;
import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Licensee: Eder Pereira Silva de Brito
 * License Type: Purchased
 */
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="Empresa")
public class Empresa implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Empresa() {}

	@Id	
    @Column(name="cnpj", nullable=false, length=20)
    private String cnpj;
	
	@Column(name="razao_Social", nullable=false, length=150)	
	private String razaoSocial;
	
	@Column(name="nome_Fantasia", nullable=false, length=150)	
	private String nomeFantasia;
	
	@Column(name="idnaturezajuridica", nullable=false, length=10)	
	private int idnaturezajuridica;
	
	@Column(name="cnae", nullable=false, length=10)	
	private int cnae;
	
	@ManyToOne(targetEntity=EnquadramentoTributario.class, fetch=FetchType.LAZY)	
	@JoinColumns({ @JoinColumn(name="idenquadramento", referencedColumnName="idenquadramento", nullable=false) })	
	private EnquadramentoTributario enquadramento;
	
	@ManyToOne(targetEntity=Logradouro.class, fetch=FetchType.LAZY)	
	@JoinColumns({ @JoinColumn(name="idlogradouro", referencedColumnName="idlogradouro", nullable=false) })		
	private Logradouro logradouro;
	
	@OneToMany(mappedBy="empresa", targetEntity=ContratoTrabalho.class)	
	private Set<ContratoTrabalho> contratos = new HashSet<>();
	
	@ManyToMany(targetEntity=Imposto.class)
	@Cascade({SAVE_UPDATE, LOCK})
    @JoinTable(name="Empresa_Imposto", joinColumns={ @JoinColumn(name="cnpj") }, inverseJoinColumns={ @JoinColumn(name="idimposto") })
	private Set<Imposto> impostos = new HashSet<>();

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
   
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public int getIdnaturezajuridica() {
        return idnaturezajuridica;
    }

    public void setIdnaturezajuridica(int idnaturezajuridica) {
        this.idnaturezajuridica = idnaturezajuridica;
    }

    public int getCnae() {
        return cnae;
    }

    public void setCnae(int cnae) {
        this.cnae = cnae;
    }

    public EnquadramentoTributario getIdenquadramento() {
        return enquadramento;
    }

    public void setIdenquadramento(EnquadramentoTributario enquadramento) {
        this.enquadramento = enquadramento;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public Set<ContratoTrabalho> getContratos() {
        return contratos;
    }

    public void setContratos(Set<ContratoTrabalho> contratos) {
        this.contratos = contratos;
    }

    public Set<Imposto> getImpostos() {
        return impostos;
    }

    public void setImpostos(Set<Imposto> impostos) {
        this.impostos = impostos;
    }

    public String toString() {
		return String.valueOf(getCnpj());
	}
	
	@Transient	
	private boolean _saved = false;
	
	public void onSave() {
		_saved=true;
	}
	
	
	public void onLoad() {
		_saved=true;
	}
	
	
	public boolean isSaved() {
		return _saved;
	}
	
	
}
