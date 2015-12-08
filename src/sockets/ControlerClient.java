package sockets;

public class ControlerClient {
	
	public static void main(String[] zero)
	{
		Communication clientCommunication = new Client();
		clientCommunication.receiveMessage();
		clientCommunication.sendMessage("ouais gros je suis controleur client");
	}
	
	
}
