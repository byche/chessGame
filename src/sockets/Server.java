package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Communication{
	
	private ServerSocket server;
	
	public Server(){
	
	
	try {
		server = new ServerSocket(2009);
		socket = server.accept();
		//action
		server.close();
		socket.close();
		
	} catch (IOException e) {
		
	}
	}

}
