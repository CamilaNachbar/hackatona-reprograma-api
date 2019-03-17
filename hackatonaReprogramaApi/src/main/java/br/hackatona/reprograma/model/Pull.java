package br.hackatona.reprograma.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "pull")
public class Pull {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pull_id", nullable = false, unique = true)
	private String id;

	@Column(name = "valor")
	private BigDecimal valor;

	@Column(name = "valorparcela")
	private BigDecimal valorparcela;
	
	@Column(name = "data")
	private Date data;

	@Column(name = "numeroparcela")
	private int numeroparcela;
	
	@ManyToMany
	@JoinTable(name = "pull_has_type", joinColumns = { @JoinColumn(name = "pull_id") }, inverseJoinColumns = {
			@JoinColumn(name = "tipo_id") })
	private List<Tipo> tipo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorparcela() {
		return valorparcela;
	}

	public void setValorparcela(BigDecimal valorparcela) {
		this.valorparcela = valorparcela;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getNumeroparcela() {
		return numeroparcela;
	}

	public void setNumeroparcela(int numeroparcela) {
		this.numeroparcela = numeroparcela;
	}

	public List<Tipo> getTipo() {
		return tipo;
	}

	public void setTipo(List<Tipo> tipo) {
		this.tipo = tipo;
	}
	
}
