package br.hackatona.reprograma.model;

import com.ibm.watson.developer_cloud.assistant.v2.model.MessageContext;
import com.ibm.watson.developer_cloud.assistant.v2.model.MessageInput;

public class AssistentModel {

	private Input input;
	private MessageContext context;

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

	public MessageContext getContext() {
		return context;
	}

	public void setContext(MessageContext context) {
		this.context = context;
	}

}
