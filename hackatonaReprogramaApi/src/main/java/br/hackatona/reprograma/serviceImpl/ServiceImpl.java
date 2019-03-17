package br.hackatona.reprograma.serviceImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.hackatona.reprograma.repository.PullRepository;

@Service
@Transactional
public class ServiceImpl  implements br.hackatona.reprograma.serviceImpl.Service{

	@Autowired
	public PullRepository pullRepository;

	public BigDecimal getPorcentagemDecosumo(BigDecimal user, BigDecimal otherUsers) {

		return (otherUsers.multiply(new BigDecimal(100))).divide(user);

	}

	public Object getPorcentagemUsuarioPorTipo() {
		return pullRepository.findAll();
	}

}
