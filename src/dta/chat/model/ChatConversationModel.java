package dta.chat.model;

import dta.chat.model.observer.ChatObservable;

public class ChatConversationModel extends ChatObservable<ChatMessage> {
	
	
	private String login;
	
	
	public void setLogin(String login) {
		
		this.login = login;
		
		
	}

	public void sendMessage(String text) {
		
		ChatMessage msg = new ChatMessage(login, text);
		
		if (msg.getLogin() != null) {
			
			notifyObserver(msg);
			
		} 
		
	}
}
