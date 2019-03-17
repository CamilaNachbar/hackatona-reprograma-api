package br.hackatona.reprograma.controller;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.hackatona.reprograma.model.AssistentModel;
import br.hackatona.reprograma.serviceImpl.AssistantServiceImpl;
import br.hackatona.reprograma.serviceImpl.ServiceImpl;

@CrossOrigin
@RestController
public class ServiceController {

	@Autowired
	private ServiceImpl serviceImpl;
	
	@Autowired
	private AssistantServiceImpl assistante;
	
	@GetMapping(name = "/dados")
	public Object getInformations() throws JsonParseException, JsonMappingException, IOException {
		return serviceImpl.getAll();
	}
	
	
	@PostMapping(name ="/assistant")
	public Object assistant(@RequestBody AssistentModel message) throws JSONException, JsonProcessingException,IOException {
		return assistante.assistantLello(message);
	}
	
}
