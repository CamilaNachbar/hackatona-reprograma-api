package br.hackatona.reprograma.model;

import java.math.BigDecimal;

public class ComprasPercentual {

	
	private BigDecimal valorPercentual;
	private Tipo tipo;
	
	public BigDecimal getValorPercentual() {
		return valorPercentual;
	}
	public void setValorPercentual(BigDecimal valorPercentual) {
		this.valorPercentual = valorPercentual;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}


}
