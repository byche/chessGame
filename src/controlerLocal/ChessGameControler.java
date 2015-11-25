package controlerLocal;

import observable.ChessGame;
import model.Coord;
import model.Couleur;
import controler.ChessGameControlers;

public class ChessGameControler implements ChessGameControlers {
	
	private ChessGame chessGame;
	
	public ChessGameControler(ChessGame chessgame)
	{
		this.chessGame = chessgame;
	}

	@Override
	public boolean move(Coord initCoord, Coord finalCoord) {
		// TODO Auto-generated method stub
		boolean hasMoved = chessGame.move(initCoord.x, initCoord.y, finalCoord.x, finalCoord.y);
		return hasMoved;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return chessGame.getMessage();
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return chessGame.isEnd();
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		// TODO Auto-generated method stub
		return chessGame.getColorCurrentPlayer();
	} 
	

}
