package sockets;

import java.io.PrintWriter;

public class Emission implements Runnable {
	
	private PrintWriter out;
	private String message = "";
	
	public Emission(PrintWriter out, String mess)
	{
		this.out = out;
		this.message = mess;
		
	}
	
	public void setMessage(String message){
		
		this.message = message;
		System.out.println(message);
		Thread thread = new Thread(this);
		thread.start();
		
	}
	
	public void run() {
		// TODO Auto-generated method stub
	
			out.println(message);
			
			out.flush();
			
		
		
	}

	
	// envoyer des informations via le socket?
	// methodes qui permettent d'envoyer des informations
}
