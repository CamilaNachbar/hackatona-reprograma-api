package br.hackatona.reprograma.serviceImpl;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.developer_cloud.assistant.v2.Assistant;
import com.ibm.watson.developer_cloud.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.developer_cloud.assistant.v2.model.MessageContext;
import com.ibm.watson.developer_cloud.assistant.v2.model.MessageInput;
import com.ibm.watson.developer_cloud.assistant.v2.model.MessageOptions;
import com.ibm.watson.developer_cloud.assistant.v2.model.MessageResponse;
import com.ibm.watson.developer_cloud.assistant.v2.model.SessionResponse;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

import br.hackatona.reprograma.model.AssistentModel;

@Service

public class AssistantServiceImpl implements AssistanteService {

	@Autowired
	private ServiceImpl serviceImpl;

	@Override
	public Object assistantLello(AssistentModel line) throws JSONException, IOException {

		@SuppressWarnings({ "resource" })

		IamOptions iamOptions = new IamOptions.Builder().apiKey("jzGsQVpfIrcH1rVgg20fjJ1jQTHmMM__Dqf1fBANseBl").build();
		Assistant service = new Assistant("2018-11-08", iamOptions);
		service.setEndPoint("https://gateway.watsonplatform.net/assistant/api");

		if (line.getSessionId() == null) {
			CreateSessionOptions options = new CreateSessionOptions.Builder("ca4d095e-1895-48b5-9315-39125cc5b1fb")
					.build();
			SessionResponse response = service.createSession(options).execute();
			line.setSessionId(response.getSessionId());
		}

		MessageInput input = null;
		MessageOptions messageOptions;

		if (line.getEntities() != null && line.getIntents() != null) {
			input = new MessageInput.Builder().text(line.getText()).entities(line.getEntities())
					.intents(line.getIntents()).build();
		}
		if (line.getIntents() != null) {
			input = new MessageInput.Builder().text(line.getText()).intents(line.getIntents()).build();
		}
		if (line.getEntities() != null) {
			input = new MessageInput.Builder().text(line.getText()).entities(line.getEntities()).build();
		}

		if (line.getContext() != null) {
			messageOptions = new MessageOptions.Builder().assistantId("ca4d095e-1895-48b5-9315-39125cc5b1fb")
					.sessionId(line.getSessionId()).input(input).build();
		} else {
			input = new MessageInput.Builder().text(line.getText()).build();
			messageOptions = new MessageOptions.Builder().assistantId("ca4d095e-1895-48b5-9315-39125cc5b1fb")
					.sessionId(line.getSessionId()).input(input).context((MessageContext) line.getContext()).build();
		}

		MessageResponse messageResponse = service.message(messageOptions).execute();

		ObjectMapper mapper = new ObjectMapper();

		String jsonInString = mapper.writeValueAsString(messageResponse);
		JSONObject object = new JSONObject(jsonInString);
		JSONObject output = object.getJSONObject("output");
		JSONArray entities = output.getJSONArray("entities");
		JSONArray intents = output.getJSONArray("entities");

		for (int i = 0; entities.length() > i; i++) {
			JSONObject entity = entities.getJSONObject(i);
			if (entity.getString("value").equals("data")) {
				output.put("context", serviceImpl.getAll());
			}
		}
		for (int i = 0; intents.length() > i; i++) {
			JSONObject intenty = intents.getJSONObject(i);
			if (intenty.getString("intents").equals("intent")) {
				JSONObject contextObj = new JSONObject();
				JSONObject action = new JSONObject();

				action.put("tittle", "Transporte");
				action.put(" payload", "transporte");
				contextObj.put("action", action);

			}
		}
		object.put("sessionId", line.getSessionId());

		return mapper.readValue(object.toString(), Object.class);

	}

}
