package br.hackatona.reprograma.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo")
public class Tipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipo_id", nullable = false, unique = true)
	private int id;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "prioridade")
	private int prioridade;
	
	@ManyToMany(mappedBy = "tipo")
	private List<Pull> pull;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public List<Pull> getPull() {
		return pull;
	}

	public void setPull(List<Pull> pull) {
		this.pull = pull;
	}


}
