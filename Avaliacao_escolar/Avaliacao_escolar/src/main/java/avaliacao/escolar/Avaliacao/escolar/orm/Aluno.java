package avaliacao.escolar.Avaliacao.escolar.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {

	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column
	private Integer matricula;
	@Column
	String nome;
	@Column
	float nota1b;
	@Column
	float nota2b;
	@Column
	float nota3b;
	@Column
	float nota4b;
	@Column
	Integer freq;
	@Column
	String situacao;
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getNota1b() {
		return nota1b;
	}
	public void setNota1b(float nota1b) {
		this.nota1b = nota1b;
	}
	public float getNota2b() {
		return nota2b;
	}
	public void setNota2b(float nota2b) {
		this.nota2b = nota2b;
	}
	public float getNota3b() {
		return nota3b;
	}
	public void setNota3b(float nota3b) {
		this.nota3b = nota3b;
	}
	public float getNota4b() {
		return nota4b;
	}
	public void setNota4b(float nota4b) {
		this.nota4b = nota4b;
	}
	public Integer getFreq() {
		return freq;
	}
	public void setFreq(Integer freq) {
		this.freq = freq;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}