package br.hackatona.reprograma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hackatona.reprograma.serviceImpl.ServiceImpl;

@CrossOrigin
@RestController
public class ServiceController {

	@Autowired
	private ServiceImpl serviceImpl;
	
	@GetMapping(name = "/user")
	public Object getInformations() {
		return serviceImpl.getPorcentagemUsuarioPorTipo();
	}
}
