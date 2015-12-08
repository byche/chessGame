package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class Communication{
	
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	Emission emission;
	Reception reception;
	
	
	public void sendMessage(String message)
	{
		System.out.println("sending message");
		try {
			out = new PrintWriter(socket.getOutputStream());
			emission = new Emission(out,message);
			emission.setMessage(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public void receiveMessage()
	{
		System.out.println("receiving message");
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Thread tReception = new Thread(new Reception(in));
			tReception.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
