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
import javax.persistence.*;

@Entity
public class Colaborador implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Colaborador() {	}

	@Id
    @Column(name="cpf", nullable=false, length=11)
	private String cpf;

	@Column(name="nome", nullable=false, length=50)	
	private String nome;
	
	@Column(name="sobrenome", nullable=false, length=100)	
	private String sobrenome;
	
	@Column(name="rg", nullable=false, length=11)
	private String rg;
	
	@Column(name="pis", nullable=false, length=11)	
	private String pis;
	
	@Column(name="num_Carteira_Trabalho", nullable=false, length=6)
	private String numCarteiraTrabalho;
	
	@Column(name="nome_Pai", nullable=false, length=100)	
	private String nomePai;
	
	@Column(name="nome_Mae", nullable=false, length=100)	
	private String nomeMae;
	
	@Column(name="cartao", nullable=false, length=50)	
	private String cartao;
	
	@ManyToOne(targetEntity=Logradouro.class, fetch=FetchType.LAZY)		
	@JoinColumns({ @JoinColumn(name="idlogradouro", referencedColumnName="idlogradouro", nullable=false) })	
	private Logradouro logradouro;
	
	@OneToOne(mappedBy="colaborador", targetEntity=ContratoTrabalho.class, fetch=FetchType.LAZY)	
	private ContratoTrabalho contratoTrabalho;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getNumCarteiraTrabalho() {
        return numCarteiraTrabalho;
    }

    public void setNumCarteiraTrabalho(String numCarteiraTrabalho) {
        this.numCarteiraTrabalho = numCarteiraTrabalho;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public ContratoTrabalho getContratoTrabalho() {
        return contratoTrabalho;
    }

    public void setContratoTrabalho(ContratoTrabalho contratoTrabalho) {
        this.contratoTrabalho = contratoTrabalho;
    }
}
