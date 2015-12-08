package sockets;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Client extends Communication{
	
	private int port;
	
	public Client(){
		
		try{
			socket = new Socket(InetAddress.getLocalHost(),2009);
			System.out.println("demande de connexion");
			socket.close();
			
		}
		catch(IOException e)
		{
			
		}
	}
	
public Client(int port){
		
		port = this.port;
		
		
		try{
			socket = new Socket(InetAddress.getLocalHost(),port);
			System.out.println("demande de connexion");
			socket.close();
			
		}
		catch(IOException e)
		{
			
		}
	}



}
