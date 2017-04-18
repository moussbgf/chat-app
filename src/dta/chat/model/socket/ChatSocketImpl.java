package dta.chat.model.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import dta.chat.domain.ChatMessage;

public class ChatSocketImpl extends Socket implements ChatSocket {

	private ObjectInputStream serverInput;
	private ObjectOutputStream serverOuput;

	private ClientSocket clientSocket;

	public ChatSocketImpl(String hostname, Integer port) {

		try {
			clientSocket = new ClientSocket(hostname, port);
		} catch (IOException e) {
			throw new ChatClientException("Problème de connexion au server", e);
			// e.printStackTrace();
		}
	}

	@Override
	public void close() {

		try {
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new ChatClientException("Problème de connexion au server", e);

		}

	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		// return this.serverInput.readObject();

		try {
			clientSocket.sendObject(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			throw new ChatClientException("Problème de connexion au server", e);

		}
	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		// TODO Auto-generated method stub
		try {
			return (ChatMessage) clientSocket.readObject();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ChatClientException("Rien à envoyer", e);
		}

	}

}
