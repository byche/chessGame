package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Communication{
	
	private ServerSocket server;
	int port;
	
	public Server(){
	
	this.port = 2009;
	try {
		server = new ServerSocket(port);
		socket = server.accept();
		System.out.println("connécté!");

		
	} catch (IOException e) {
		
	}
	}
	
	public Server(int port){
		
		this.port = port;
		
		try {
			server = new ServerSocket(port);
		
			System.out.println("en attente du client");
			socket = server.accept();
			System.out.println("connécté!");

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
