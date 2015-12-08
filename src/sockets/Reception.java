package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import static java.lang.Thread.sleep;

public class Reception implements Runnable {

	private BufferedReader in;
	private String message = null;


	public Reception(BufferedReader in)
	{
		this.in = in;
	}
	
	public String getMessage(){
		if(message.equals(null))
		{
			return null;
		}
		return message; 
	}
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			
			try {
				sleep(500);
				message = in.readLine();
				System.out.println(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		catch (InterruptedException e) {

			e.printStackTrace();
		}
			
		}
		
		
		
	}

	//recevoir des informations via le socket?
	//methodes qui permettent de recevoir des informations
	
	

}
