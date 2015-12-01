package launcher.distantlauncher;

import javax.swing.WindowConstants;

import observable.ChessGame;
import sockets.Client;
import sockets.Communication;
import sockets.Server;
import vue.ChessGameGUI;
import controlerDistant.ChessGameControlerDistant;

public class DistantLauncherGUIClient {

	
	 

	
		public static void main(String[] args) {
			  


			Communication client = new Client();
			
			ChessGame chessGame;
			ChessGameControlerDistant chessGameControlerDistantClient;
				  			
			chessGame = new ChessGame();	
			chessGameControlerDistantClient = new ChessGameControlerDistant(chessGame,client);
				  
		
			ChessGameGUI chessGameGUIClient = new ChessGameGUI(chessGameControlerDistantClient);
			chessGameGUIClient.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE );
			chessGameGUIClient.pack();
			chessGameGUIClient.setResizable(true);
			chessGameGUIClient.setLocationRelativeTo( null );
			chessGameGUIClient.setVisible(true);
			
			chessGame.addObserver(chessGameGUIClient);
			
			chessGame.notifyObservers();


		}
}

