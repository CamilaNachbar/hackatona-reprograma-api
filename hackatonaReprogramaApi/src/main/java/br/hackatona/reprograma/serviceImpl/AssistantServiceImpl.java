package br.hackatona.reprograma.serviceImpl;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.developer_cloud.assistant.v1.Assistant;
import com.ibm.watson.developer_cloud.assistant.v1.model.Context;
import com.ibm.watson.developer_cloud.assistant.v1.model.InputData;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

@Service
@Transactional
public class AssistantServiceImpl implements AssistantService {

	
	@Override
	public String assistantLello(String line) {
		try {
			@SuppressWarnings({ "resource" })
			ObjectMapper mapper = new ObjectMapper();
			
			IamOptions iamOptions = new IamOptions.Builder().apiKey("b55rXwpeRVh9aLTBdh0Jt3JfD2a4q_W5ZH0WzYIHNQWk").build();
			Assistant service = new Assistant("2018-09-20", iamOptions);
			service.setEndPoint("https://gateway.watsonplatform.net/assistant/api");

			String workspaceId = "{workspace_id}";
			
			MessageOptions options;
			JSONObject conversation = new JSONObject(line);

			if (conversation.has("context") && !conversation.isNull("context")) {

				Context context = mapper.readValue(conversation.getJSONObject("context").toString(), Context.class);
				InputData input = new InputData.Builder(conversation.getString("text")).build();
				options = new MessageOptions.Builder(workspaceId).input(input).context(context).build();

			} else {

				InputData input = new InputData.Builder(conversation.getString("text")).build();
				options = new MessageOptions.Builder(workspaceId).input(input).build();

			}

			return service.message(options).execute().toString();

		} catch (Exception e) {
			return "error " + e;
		}
	}
	
	
	@Override
	public JSONObject assistantMatching(String matchingText) {
		// retorna true caso as entidades conhecidam com o texto retornado do Discovery

		Assistant service = new Assistant("2018-07-10");
		service.setUsernameAndPassword("cdf02a35-735a-4ff7-8d6a-90e8d292a8df", "DW6sSsJo8jXF");

		final String workspaceId = "e0f5b820-1bcb-4e05-8207-7964ecd6ac5d";

		InputData input = new InputData.Builder(matchingText).build();

		MessageOptions options = new MessageOptions.Builder(workspaceId).input(input).build();
		return null;//new JSONObject(service.message(options).execute().toString());

	}

}
