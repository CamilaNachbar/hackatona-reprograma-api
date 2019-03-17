package br.hackatona.reprograma.model;

import java.math.BigDecimal;

public class ComprasPorTipo {

	private BigDecimal valor;
	private Tipo tipo;

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
