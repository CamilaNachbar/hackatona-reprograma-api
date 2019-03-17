package br.hackatona.reprograma.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.hackatona.reprograma.model.AssistentModel;
import br.hackatona.reprograma.serviceImpl.AssistantServiceImpl;

@CrossOrigin
@RestController
public class ServiceController {

	/*@Autowired
	private ServiceImpl serviceImpl;
	*/
	@Autowired
	private AssistantServiceImpl assistante;
	
/*	@GetMapping(name = "/user")
	public Object getInformations() {
		return serviceImpl.getPorcentagemUsuarioPorTipo();
	}*/
	
	
	@PostMapping(name ="/assistant")
	public Object assistant(@RequestBody AssistentModel message) throws JSONException {
		return assistante.assistantLello(message);
	}
	
}
