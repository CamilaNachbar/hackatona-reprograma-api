package br.hackatona.reprograma.serviceImpl;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public interface AssistantService {
	public JSONObject assistantMatching(String matchingText);

	public String assistantLello(String line);
}
