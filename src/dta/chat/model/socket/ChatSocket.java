package dta.chat.model.socket;

import java.io.IOException;

import dta.chat.domain.ChatMessage;

public interface ChatSocket extends AutoCloseable{
	
	void sendMessage(ChatMessage msg) throws ChatClientException;
	
	ChatMessage readMessage() throws ChatClientException;
	
}
