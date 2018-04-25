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

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="Logradouro")
public class Logradouro implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Logradouro() {}
	

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idlogradouro", nullable=false, length=10)
	private int idlogradouro;
	
	@Column(name="rua", nullable=false, length=150)	
	private String rua;
	
	@Column(name="bairro", nullable=false, length=100)	
	private String bairro;
	
	@Column(name="municipio", nullable=true, length=150)	
	private String municipio;
	
	@Column(name="cidade", nullable=false, length=100)	
	private String cidade;
	
	@Column(name="estado", nullable=false, length=100)	
	private String estado;
	
	@Column(name="cep", nullable=false, length=8)
	private String cep;
	
	@Column(name="pais", nullable=false, length=75)	
	private String pais;
	
	@OneToMany(mappedBy="logradouro", targetEntity=Colaborador.class)	
	private Set<Colaborador> colaboradores = new HashSet<>();
	
	@OneToMany(mappedBy="logradouro", targetEntity=Empresa.class)	
	private Set<Empresa> empresas = new HashSet<>();

    public int getIdlogradouro() {
        return idlogradouro;
    }

    public void setIdlogradouro(int idlogradouro) {
        this.idlogradouro = idlogradouro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Set<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(Set<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public Set<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Set<Empresa> empresas) {
        this.empresas = empresas;
    }
}
