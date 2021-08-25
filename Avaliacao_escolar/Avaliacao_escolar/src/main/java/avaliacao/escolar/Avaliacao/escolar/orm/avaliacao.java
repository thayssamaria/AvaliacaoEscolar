package avaliacao.escolar.Avaliacao.escolar.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacoes")
public class avaliacao {

	public avaliacao() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public float getPart() {
		return part;
	}
	public void setPart(float part) {
		this.part = part;
	}
	public float getTarefa() {
		return tarefa;
	}
	public void setTarefa(float tarefa) {
		this.tarefa = tarefa;
	}
	public float getTrabalho() {
		return trabalho;
	}
	public void setTrabalho(float trabalho) {
		this.trabalho = trabalho;
	}
	public float getProva() {
		return prova;
	}
	public void setProva(float prova) {
		this.prova = prova;
	}
	public Integer getBimestre() {
		return bimestre;
	}
	public void setBimestre(Integer bimestre) {
		this.bimestre = bimestre;
	}
	public Integer getFalta() {
		return falta;
	}
	public void setFalta(Integer falta) {
		this.falta = falta;
	}

	@Column
	private Integer matricula;
	@Column
	float part;
	@Column
	float tarefa;
	@Column
	float trabalho;
	@Column
	float prova;
	@Column
	Integer bimestre;
	@Column
	Integer falta;
	
}

	