package br.hackatona.reprograma.serviceImpl;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.hackatona.reprograma.model.AssistentModel;

@Component
public interface AssistanteService {

	public Object assistantLello(AssistentModel line) throws JSONException,JsonProcessingException,IOException ;
}
