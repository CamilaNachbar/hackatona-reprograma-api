package br.hackatona.reprograma.model;

public class Dados {
	
	private CardCredit cartao;
	private Pull compras;
	private ComprasPorTipo comprasPorTipo;
	public CardCredit getCartao() {
		return cartao;
	}
	public void setCartao(CardCredit cartao) {
		this.cartao = cartao;
	}
	public Pull getCompras() {
		return compras;
	}
	public void setCompras(Pull compras) {
		this.compras = compras;
	}
	public ComprasPorTipo getComprasPorTipo() {
		return comprasPorTipo;
	}
	public void setComprasPorTipo(ComprasPorTipo comprasPorTipo) {
		this.comprasPorTipo = comprasPorTipo;
	}
}
