package dta.chat.view.console;

public class ChatConsoleView extends ViewComposite {
	
	
	
	public ChatConsoleView(ChatConsoleTitleView titleView, ChatConsoleLoginView loginView, ChatConsoleConversationView conversationView) {
		
		this.add(titleView);
		this.add(loginView);
		this.add(conversationView);
	}

	@Override
	public void printBefore() {
		// TODO Auto-generated method stub
		
	}

}
