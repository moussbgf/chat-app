package dta.chat.model.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket extends Socket {

	private ObjectInputStream serverInput;
	private ObjectOutputStream serverOuput;

	public ClientSocket(String hostname, Integer port) throws IOException {
		super(hostname, port);
		this.serverInput = new ObjectInputStream(this.getInputStream());
		this.serverOuput = new ObjectOutputStream(this.getOutputStream());
	}
	
	public void sendObject(Object obj) throws IOException {
		this.serverOuput.writeObject(obj);
	}
	
	public Object readObject() throws IOException, ClassNotFoundException {
		return this.serverInput.readObject();
	}
	
	// Pour démo
	public static void main(String[] args) throws IOException {
		ClientSocket client = new ClientSocket("localhost", 1800);
		client.sendObject("Bonjour");
		client.close();
		// client.readObject(); // pour recevoir un message du serveur
		
	}

}
