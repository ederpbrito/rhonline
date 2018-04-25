package br.com.rhonline.model;

/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Eder Pereira Silva de Brito
 * License Type: Purchased
 */
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static org.hibernate.annotations.CascadeType.LOCK;
import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;
import static org.hibernate.annotations.LazyCollectionOption.TRUE;

@Entity
public class Imposto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Imposto() {}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idimposto", nullable=false, length=10)
	private int idimposto;
	
	@Column(name="descricao", nullable=false, length=100)	
	private String descricao;
	
	@Column(name="dt_pagamento", nullable=false)	
	@Temporal(TemporalType.DATE)	
	private Date dt_pagamento;
	
	@Column(name="valor", nullable=false, length=10)	
	private double valor;
	
	@ManyToMany(mappedBy="impostos", targetEntity=Empresa.class)
	@Cascade({SAVE_UPDATE, LOCK})
	@LazyCollection(TRUE)
	private Set<Empresa> empresas = new HashSet<>();

    public int getIdimposto() {
        return idimposto;
    }

    public void setIdimposto(int idimposto) {
        this.idimposto = idimposto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDt_pagamento() {
        return dt_pagamento;
    }

    public void setDt_pagamento(Date dt_pagamento) {
        this.dt_pagamento = dt_pagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Set<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Set<Empresa> empresas) {
        this.empresas = empresas;
    }
}
