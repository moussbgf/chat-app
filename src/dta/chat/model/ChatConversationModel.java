package dta.chat.model;

import dta.chat.domain.ChatMessage;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.socket.ChatClientException;
import dta.chat.model.socket.ChatSocket;
import dta.chat.model.socket.ChatSocketImpl;

public class ChatConversationModel extends ChatObservable<ChatMessage> {
	
	
	private String login;
	private ChatSocket chatSocket;
	
	
	public void setLogin(String login) {
		
		this.login = login;
		
		
	}

	public void sendMessage(String text) {
		
		ChatMessage msg = new ChatMessage(login, text);
		
		chatSocket.sendMessage(msg);
		
		if (msg.getLogin() != null) {
			
			notifyObserver(msg);
			
		} 
		
	}
	
	
	public void startListening () {
		
		try {
			chatSocket.readMessage();
		} catch (ChatClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ChatConversationModel (ChatSocket chatSocket) {
		
		new Thread (() -> {
			// code du start()
			
			while (true) {
				ChatMessage message = chatSocket.readMessage();
				notifyObserver(message);
			}
			
		}).start();
		
		
		this.chatSocket = chatSocket;
		
	}
	
	
}
