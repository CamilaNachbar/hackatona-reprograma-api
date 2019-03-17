package br.hackatona.reprograma.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card")

public class CardCredit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "card_id", nullable = false, unique = true)
	private int id;

	@Column(name = "numero")
	private Float numero;

	@Column(name = "limiteTotal")
	private BigDecimal limiteTotal;
	
	@Column(name = "limiteAtual")
	private BigDecimal limiteAtual;

}
