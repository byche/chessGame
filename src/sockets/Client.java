package sockets;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Client extends Communication{
	

	
	public Client(){
		
		try{
			socket = new Socket(InetAddress.getLocalHost(),2009);
			socket.close();
		}
		catch(IOException e)
		{
			
		}
	}

}
