package br.hackatona.reprograma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hackatona.reprograma.serviceImpl.AssistantServiceImpl;
import br.hackatona.reprograma.serviceImpl.ConversationApiService;
import br.hackatona.reprograma.serviceImpl.ServiceImpl;

@CrossOrigin
@RestController
public class ServiceController {

	@Autowired
	private ServiceImpl serviceImpl;
	
	@Autowired
	private AssistantServiceImpl assistante;
	
	@GetMapping(name = "/user")
	public Object getInformations() {
		return serviceImpl.getPorcentagemUsuarioPorTipo();
	}
	
	
	@PostMapping(name ="/assistant")
	public Object assistant(String message) {
		return assistante.assistantLello(message);
	}
	
}
