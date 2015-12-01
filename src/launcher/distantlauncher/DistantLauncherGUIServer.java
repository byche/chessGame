package launcher.distantlauncher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import observable.ChessGame;
import sockets.Client;
import sockets.Communication;
import sockets.Server;
import vue.ChessGameCmdLine;
import vue.ChessGameGUI;
import controlerDistant.ChessGameControlerDistant;
import controlerLocal.ChessGameControler;

public class DistantLauncherGUIServer {

	 
	 

	
	public static void main(String[] args) {
		  
		  
			Communication server = new Server();
		
		  ChessGame chessGame;
		  ChessGameControlerDistant chessGameControlerDistant;
			  
			 
				
		  chessGame = new ChessGame();	
		  chessGameControlerDistant = new ChessGameControlerDistant(chessGame,server);
			  
		  ChessGameGUI chessGameGUI = new ChessGameGUI(chessGameControlerDistant);
		  chessGameGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE );
		  chessGameGUI.pack();
		  chessGameGUI.setResizable(true);
		  chessGameGUI.setLocationRelativeTo( null );
		  chessGameGUI.setVisible(true);
		  
		
		  
		  chessGame.addObserver(chessGameGUI);
	
		  
		  chessGame.notifyObservers();
		  
			  
			  }
	}

