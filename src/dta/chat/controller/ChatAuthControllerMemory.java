package dta.chat.controller;

import java.util.Arrays;
import java.util.List;

import dta.chat.model.ChatConversationModel;
import dta.chat.view.console.ChatConsoleLoginView;

public class ChatAuthControllerMemory implements ChatAuthController {

	private ChatConsoleLoginView loginView;
	private List<String> pseudoValides = Arrays.asList("admin", "mouss");
	private ChatConversationModel conversationModel;

	public ChatAuthControllerMemory(ChatConsoleLoginView loginView, ChatConversationModel conversationModel) {
		this.loginView = loginView;
		this.conversationModel = conversationModel;
	}

	@Override
	public void authenticate() {

		String pseudo = loginView.askLogin();

		if (pseudoValides.contains(pseudo)) {
			loginView.sayWelcome(pseudo);
			conversationModel.setLogin(pseudo);
		} else {
			loginView.sayAccessDenied(pseudo);
		}

	}

}
