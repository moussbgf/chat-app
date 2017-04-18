package dta.chat.view.console;

import dta.chat.domain.ChatMessage;
import dta.chat.model.observer.ChatObserver;

public class ChatConsoleConversationView extends ViewComposite implements ChatObserver<ChatMessage> {

	public ChatConsoleConversationView() {
		
	}

	@Override
	public void printBefore() {
		System.out.println("== Conversation ==");
	}

	@Override
	public void update(ChatMessage msg) {
		
		System.out.println(msg.getLogin() + " : " + msg.getText());
		
	}
	
	

}
