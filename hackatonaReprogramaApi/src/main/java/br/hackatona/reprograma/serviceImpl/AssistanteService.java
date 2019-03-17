package br.hackatona.reprograma.serviceImpl;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.ibm.watson.developer_cloud.assistant.v2.model.MessageOptions;
import com.ibm.watson.developer_cloud.assistant.v2.model.MessageResponse;

import br.hackatona.reprograma.model.AssistentModel;

@Component
public interface AssistanteService {
	public JSONObject assistantMatching(String matchingText) throws JSONException, RuntimeException;

	public MessageResponse assistantLello(AssistentModel line) throws JSONException ;
}
