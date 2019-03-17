package br.hackatona.reprograma.serviceImpl;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class AssistantServiceImpl implements AssistanteService {

	@Override
	public MessageResponse assistantLello(AssistentModel line) throws JSONException {

		@SuppressWarnings({ "resource" })

		IamOptions iamOptions = new IamOptions.Builder().apiKey("jzGsQVpfIrcH1rVgg20fjJ1jQTHmMM__Dqf1fBANseBl").build();
		Assistant service = new Assistant("2018-11-08", iamOptions);
		service.setEndPoint("https://gateway.watsonplatform.net/assistant/api");
		CreateSessionOptions options = new CreateSessionOptions.Builder("ca4d095e-1895-48b5-9315-39125cc5b1fb").build();

		SessionResponse response = service.createSession(options).execute();

		MessageInput input = new MessageInput.Builder().text(line.getInput().getText()).build();

		MessageOptions messageOptions;

		if (line.getContext() != null) {
			messageOptions = new MessageOptions.Builder().assistantId("ca4d095e-1895-48b5-9315-39125cc5b1fb")
					.sessionId(response.getSessionId()).input(input).context(line.getContext()).build();

		} else {
			messageOptions = new MessageOptions.Builder().assistantId("ca4d095e-1895-48b5-9315-39125cc5b1fb")
					.sessionId(response.getSessionId()).input(input).build();
		}



		MessageResponse messageResponse = service.message(messageOptions).execute();
		return messageResponse;

	}

	public JSONObject assistantMatching(String matchingText) throws JSONException, RuntimeException {
		// retorna true caso as entidades conhecidam com o texto retornado do Discovery

		Assistant service = new Assistant("2018-07-10");
		service.setUsernameAndPassword("cdf02a35-735a-4ff7-8d6a-90e8d292a8df", "DW6sSsJo8jXF");

		/*
		 * final String workspaceId = "e0f5b820-1bcb-4e05-8207-7964ecd6ac5d";
		 * 
		 * InputData input = new InputData.Builder(matchingText).build();
		 */
		// MessageOptions options = new
		// MessageOptions.Builder(workspaceId).input(input).build();
		return null; // new JSONObject(service.message(options).execute().toString());

	}

}
