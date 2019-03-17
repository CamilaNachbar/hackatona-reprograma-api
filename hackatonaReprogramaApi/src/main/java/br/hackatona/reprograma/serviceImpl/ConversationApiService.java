package br.hackatona.reprograma.serviceImpl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@SuppressWarnings("deprecation")
public class ConversationApiService {

	public String Conversation(String line) {

		try {
			@SuppressWarnings("resource")
			HttpClient client = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(
					"https://gateway.watsonplatform.net/assistant/api/v1/workspaces/6577053d-3391-4b77-b1b9-a260b4d97fdb/message?version=2018-02-16");
			httpPost.setHeader("Content-Type", "application/json");
			httpPost.setHeader("Accept", "JSON");
			httpPost.setHeader("Authorization",
					"Basic NGRlYzlkNDItZmJhNS00YTE2LWEzMTctOWMxYTUzZTRlYjI3OlNnYzB0eFQ0M3NoUQ==");

			JSONObject conversation = new JSONObject(line);

			JSONObject jsonconver = new JSONObject();
			jsonconver.put("text", conversation.getString("text"));

			JSONObject jsonconversation = new JSONObject();
			if (!conversation.getString("context").toString().equals("null")) {

				jsonconversation.put("context", conversation.getJSONObject("context"));
			}
			jsonconversation.put("input", jsonconver);

			System.out.println(jsonconversation.toString());

			StringEntity content = new StringEntity(jsonconversation.toString(), "UTF8");
			httpPost.setEntity(content);

			// Execute and get the response.
			HttpResponse response = client.execute(httpPost);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				try (InputStream stream = entity.getContent()) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
					String input;
					StringBuilder sb = new StringBuilder();
					while ((input = reader.readLine()) != null) {
						sb.append(input);
						return input;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			return "error " + e;
		}
		return null;
	}

}
