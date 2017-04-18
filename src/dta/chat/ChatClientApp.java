package dta.chat;

import java.util.Scanner;
import dta.chat.controller.ChatAuthControllerMemory;
import dta.chat.model.ChatConversationModel;
import dta.chat.model.socket.ChatSocket;
import dta.chat.model.socket.ChatSocketImpl;
import dta.chat.view.console.ChatConsoleConversationView;
import dta.chat.view.console.ChatConsoleLoginView;
import dta.chat.view.console.ChatConsoleTitleView;
import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	private static final int SERVER_PORT = 1800;
//	private static final String SERVER_HOST = "ns377570.ip-5-196-89.eu";
	private static final String SERVER_HOST = "localhost";

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			ChatConsoleTitleView titleView = new ChatConsoleTitleView();
			ChatConsoleLoginView loginView = new ChatConsoleLoginView(sc);
			ChatConsoleConversationView conversation = new ChatConsoleConversationView();
			ChatConsoleView consoleView = new ChatConsoleView(titleView, loginView, conversation);
			
			ChatSocket chatSocket = new ChatSocketImpl(SERVER_HOST, SERVER_PORT);
			
			//model
			ChatConversationModel conversationModel = new ChatConversationModel(chatSocket);
			conversationModel.addObserver(conversation);
			
			
			// définition de la stratégie de controlle de l'authentification
			loginView.setAuthController(new ChatAuthControllerMemory(loginView, conversationModel));


			consoleView.print();
			
			
			conversationModel.sendMessage("hello !");
			
//			conversationModel.sendMessage("modification du model");
//			conversationModel.sendMessage("");
			
		}

	}

}
