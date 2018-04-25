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
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="Contrato_Trabalho")
public class ContratoTrabalho implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContratoTrabalho() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmatricula", nullable=false, length=10)
	private int idmatricula;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "dt_Admissao", nullable = false)
    private Date dt_Admissao;
	
	@Column(name="modalidade_Contratacao", nullable=false, length=10)	
	private int modalidadeContratacao;
	
	@Column(name="salario_Base", nullable=false, precision=19, scale=0)	
	private BigDecimal salarioBase;
	
	@Column(name="carga_Horaria", nullable=false, length=10)	
	private int cargaHoraria;
	
	@Column(name="endereco_Trabalho", nullable=false, length=100)	
	private String enderecoTrabalho;

	@ManyToOne(targetEntity=Empresa.class, fetch=FetchType.LAZY)		
	@JoinColumns({ @JoinColumn(name="cnpj", referencedColumnName="cnpj", nullable=false) })	
	private Empresa empresa;
	
	@OneToOne(optional=false, targetEntity=Colaborador.class, fetch=FetchType.LAZY)		
	@JoinColumns({ @JoinColumn(name="cpf", referencedColumnName="cpf", nullable=false) })	
	private Colaborador colaborador;

    public int getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(int idmatricula) {
        this.idmatricula = idmatricula;
    }

    public Date getDt_Admissao() {
        return dt_Admissao;
    }

    public void setDt_Admissao(Date dt_Admissao) {
        this.dt_Admissao = dt_Admissao;
    }

    public int getModalidadeContratacao() {
        return modalidadeContratacao;
    }

    public void setModalidadeContratacao(int modalidadeContratacao) {
        this.modalidadeContratacao = modalidadeContratacao;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getEnderecoTrabalho() {
        return enderecoTrabalho;
    }

    public void setEnderecoTrabalho(String enderecoTrabalho) {
        this.enderecoTrabalho = enderecoTrabalho;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
}
