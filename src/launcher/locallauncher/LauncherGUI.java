package launcher.locallauncher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.*;

import observable.ChessGame;
import vue.ChessGameCmdLine;
import vue.ChessGameGUI;
import controlerLocal.ChessGameControler;

public class LauncherGUI {

	 
	 

	
	public static void main(String[] args) {
		  
		  
		  
		 
		  ChessGame chessGame;
		  ChessGameControler chessGameControler;
			  
			 
				
		  chessGame = new ChessGame();	
		  chessGameControler = new ChessGameControler(chessGame);
			  
		  ChessGameGUI chessGameGUI = new ChessGameGUI(chessGameControler);
		  chessGameGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE );
		  chessGameGUI.pack();
		  chessGameGUI.setResizable(true);
		  chessGameGUI.setLocationRelativeTo( null );
		  chessGameGUI.setVisible(true);
		  
		  chessGame.addObserver(chessGameGUI);
		  
		  chessGame.notifyObservers();
			  
			  }
	}

