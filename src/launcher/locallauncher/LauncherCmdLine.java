package launcher.locallauncher;

import observable.ChessGame;
import vue.ChessGameCmdLine;
import controlerLocal.ChessGameControler;



 
public class LauncherCmdLine {
	
	public static void main(String[] args) {		
		
		ChessGame chessGame;
		ChessGameControler chessGameControler;		
		
		chessGame = new ChessGame();	
		chessGameControler = new ChessGameControler(chessGame);
		
		new ChessGameCmdLine(chessGameControler);	
	}

}
