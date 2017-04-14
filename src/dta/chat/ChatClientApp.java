package dta.chat;

import java.util.Scanner;
import dta.chat.controller.ChatAuthControllerMemory;
import dta.chat.model.ChatConversationModel;
import dta.chat.view.console.ChatConsoleConversationView;
import dta.chat.view.console.ChatConsoleLoginView;
import dta.chat.view.console.ChatConsoleTitleView;
import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			ChatConsoleTitleView titleView = new ChatConsoleTitleView();
			ChatConsoleLoginView loginView = new ChatConsoleLoginView(sc);
			ChatConsoleConversationView conversation = new ChatConsoleConversationView();
			ChatConsoleView consoleView = new ChatConsoleView(titleView, loginView, conversation);
			
			
			//model
			ChatConversationModel conversationModel = new ChatConversationModel();
			conversationModel.addObserver(conversation);
			
			
			// définition de la stratégie de controlle de l'authentification
			loginView.setAuthController(new ChatAuthControllerMemory(loginView, conversationModel));

			
			

			consoleView.print();
			
			
			conversationModel.sendMessage("Hello");
			conversationModel.sendMessage("modification du model");
			
		}

	}

}
