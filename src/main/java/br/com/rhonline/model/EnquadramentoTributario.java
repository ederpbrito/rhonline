package br.com.rhonline.model;
/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Licensee: Eder Pereira Silva de Brito
 * License Type: Purchased
 */


@Entity
public class EnquadramentoTributario implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnquadramentoTributario() {}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idenquadramento", nullable=false, length=10)
	private int idenquadramento;
	
	@Column(name="descricao", nullable=false, length=100)	
	private String descricao;
	
	@Column(name="aliquota", nullable=false, length=10)	
	private double aliquota;
	
	@OneToMany(mappedBy="enquadramento", targetEntity=Empresa.class)
	private Set<Empresa> empresas = new HashSet<>();

    public int getIdenquadramento() {
        return idenquadramento;
    }

    public void setIdenquadramento(int idenquadramento) {
        this.idenquadramento = idenquadramento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getAliquota() {
        return aliquota;
    }

    public void setAliquota(double aliquota) {
        this.aliquota = aliquota;
    }

    public Set<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Set<Empresa> empresas) {
        this.empresas = empresas;
    }
}
