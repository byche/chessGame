package sockets;

public class ControlerServer {
	
	public static void main(String[] zero)

	{
		Communication serverCommunication = new Server(2009);
		serverCommunication.receiveMessage();
		serverCommunication.sendMessage("ouais gros je suis controleur serveur");
	}

}
