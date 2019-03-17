package br.hackatona.reprograma.serviceImpl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public interface Service {
	public BigDecimal getPorcentagemDecosumo(BigDecimal user, BigDecimal otherUsers);

	public Object getPorcentagemUsuarioPorTipo();
}
