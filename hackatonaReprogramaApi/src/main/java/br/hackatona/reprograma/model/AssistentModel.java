package br.hackatona.reprograma.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.assistant.v2.model.MessageInputOptions;
import com.ibm.watson.developer_cloud.assistant.v2.model.RuntimeEntity;
import com.ibm.watson.developer_cloud.assistant.v2.model.RuntimeIntent;

public class AssistentModel {

	private String sessionId;
	private String messageType;
	private String text;
	private MessageInputOptions options;

	private List<RuntimeIntent> intents;
	private List<RuntimeEntity> entities;
	@SerializedName("suggestion_id")
	private String suggestionId;
	private Object context;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Object getContext() {
		return context;
	}

	public void setContext(Object context) {
		this.context = context;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MessageInputOptions getOptions() {
		return options;
	}

	public void setOptions(MessageInputOptions options) {
		this.options = options;
	}

	public List<RuntimeIntent> getIntents() {
		return intents;
	}

	public void setIntents(List<RuntimeIntent> intents) {
		this.intents = intents;
	}

	public List<RuntimeEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<RuntimeEntity> entities) {
		this.entities = entities;
	}

	public String getSuggestionId() {
		return suggestionId;
	}

	public void setSuggestionId(String suggestionId) {
		this.suggestionId = suggestionId;
	}

}
