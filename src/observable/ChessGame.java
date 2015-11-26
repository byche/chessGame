package observable;

import java.util.Observable;

import model.Couleur;
import model.Echiquier;

public class ChessGame extends Observable implements ChessGames {
	
	private Echiquier echiquier;
	
	public ChessGame(){
		echiquier = new Echiquier();
	}
	
	

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		
		boolean isMoveOk = echiquier.isMoveOk(xInit, yInit, xFinal, yFinal);
		
		if(isMoveOk)
		{
			echiquier.move(xInit, yInit, xFinal, yFinal);
			echiquier.switchJoueur();
		}
		
		this.notifyObservers();
		return isMoveOk;
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return echiquier.isEnd();
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		
		return echiquier.getMessage();
		
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		// TODO Auto-generated method stub
		return echiquier.getColorCurrentPlayer();
	}
	
	public String toString(){
		
		String str= echiquier.toString();
		
		return str;
	}
	
	@Override
	public void notifyObservers()
	{
		setChanged();
		notifyObservers(echiquier.getPiecesIHM());

	}
	
	

}
