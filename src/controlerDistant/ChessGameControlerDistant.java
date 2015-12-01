package controlerDistant;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import model.Coord;
import model.Couleur;
import observable.ChessGame;
import sockets.Client;
import sockets.Communication;
import sockets.Server;
import controler.ChessGameControlers;


public class ChessGameControlerDistant implements ChessGameControlers,Runnable{
	
	private ChessGame chessGame;
	
	private Communication communication;
	
	public ChessGameControlerDistant(ChessGame chessgame,Communication communication)
	{
		this.chessGame = chessgame;
		
		
	}
	

	
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public boolean move(Coord initCoord, Coord finalCoord) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public Couleur getColorCurrentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

}
