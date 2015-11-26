package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import tools.ChessImageProvider;
import model.Coord;
import model.Couleur;
import model.PieceIHM;
import controler.ChessGameControlers;
import controlerDistant.ChessGameControlerDistant;
import controlerLocal.ChessGameControler;

public class ChessGameGUI extends JFrame implements MouseListener, MouseMotionListener, Observer{
	
	private JLayeredPane layeredPane;
	 private JPanel chessBoard;
	 private JLabel chessPiece;
	private  int xAdjustment;
	 private int yAdjustment;
	 private Boolean init = true;
	 private ChessGameControler chessGameControler;
	 private ChessGameControlerDistant chessGameControlerDistant;
  
	  private int indexInit;
	  private int indexFinal;
	
	public ChessGameGUI(ChessGameControler chessGameControler)
	{
		
		this.chessGameControler = chessGameControler;
		
		  Dimension boardSize = new Dimension(600, 600);
		 
		  //  Use a Layered Pane for this this application
		 layeredPane = new JLayeredPane();
		  getContentPane().add(layeredPane);
		  layeredPane.setPreferredSize(boardSize);
		  layeredPane.addMouseListener(this);
		  layeredPane.addMouseMotionListener(this);

		  //Add a chess board to the Layered Pane 
		 
		  chessBoard = new JPanel();
		  layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		  chessBoard.setLayout( new GridLayout(8, 8) );
		  chessBoard.setPreferredSize( boardSize );
		  chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
		 
		  for (int i = 0; i < 64; i++) {
		  JPanel square = new JPanel( new BorderLayout() );
		  chessBoard.add( square );
		 
		  int row = (i / 8) % 2;
		  if (row == 0)
		  square.setBackground( i % 2 == 0 ? Color.black : Color.white );
		  else
		  square.setBackground( i % 2 == 0 ? Color.pink : Color.black );
		  }		  
		  
	}
	
	public ChessGameGUI(ChessGameControlerDistant chessGameControlerDistant)
	{
		
		this.chessGameControlerDistant = chessGameControlerDistant;
		
		  Dimension boardSize = new Dimension(600, 600);
		 
		  //  Use a Layered Pane for this this application
		 layeredPane = new JLayeredPane();
		  getContentPane().add(layeredPane);
		  layeredPane.setPreferredSize(boardSize);
		  layeredPane.addMouseListener(this);
		  layeredPane.addMouseMotionListener(this);

		  //Add a chess board to the Layered Pane 
		 
		  chessBoard = new JPanel();
		  layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		  chessBoard.setLayout( new GridLayout(8, 8) );
		  chessBoard.setPreferredSize( boardSize );
		  chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
		 
		  for (int i = 0; i < 64; i++) {
		  JPanel square = new JPanel( new BorderLayout() );
		  chessBoard.add( square );
		 
		  int row = (i / 8) % 2;
		  if (row == 0)
		  square.setBackground( i % 2 == 0 ? Color.black : Color.white );
		  else
		  square.setBackground( i % 2 == 0 ? Color.pink : Color.black );
		  }		  
		  
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
			
			List<PieceIHM> liste = (List<PieceIHM>) arg;
			initBoard(liste);
							
			revalidate();
			repaint();
	
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		// TODO Auto-generated method stub
		
		if (chessPiece == null) return;
		 chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
		 	
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
			chessPiece = null;
			Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		  
		  //TO DO
		  //recuperation de la case dans laquelle est la piece sur laquelle on a cliqué afin de recuperer les coord de la case sur le plateau
		  //cela permet d'obtenir les coordonnées initiales de la piece afin de tester le deplacement
		  //meme chose dans mouse released afin d'avoir les coordonnées finales de la piece
		 
		  if (c instanceof JPanel) 
		  return;
		  
		  Container caseCliquee = c.getParent();
		  indexInit = getComponentIndex(caseCliquee);
		 
		  Point parentLocation = c.getParent().getLocation();
		  xAdjustment = parentLocation.x - e.getX();
		  yAdjustment = parentLocation.y - e.getY();
		
		  
		  chessPiece = (JLabel)c;
		  chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		  chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		  layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(chessPiece == null) return;
		 
		  chessPiece.setVisible(false);
		  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		 
		  if (c instanceof JLabel){
			  
			 
			  //si il y a une piece surl a ccase
			  Container parent = c.getParent();
		  
			  parent.remove(0);
			  parent.add( chessPiece );
		  }
		  
		  else {
		  
			  //si la case est vide
			  Container parent = (Container)c;
			  indexFinal = getComponentIndex(parent);
			  
		  }

		  Coord initCoord = new Coord(indexInit%8,indexInit/8);
		  Coord finalCoord = new Coord(indexFinal%8,indexFinal/8);
	  
		  chessGameControler.move(initCoord,finalCoord);
		  String message = chessGameControler.getMessage();
		  System.out.println(message);
		  //pop up qui affiche les infos sur le deplacement
		  //JFrame jf = new JFrame();
		  //JOptionPane.showMessageDialog(jf, message);
		  chessPiece.setVisible(false);
		 
		  
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void initBoard(List<PieceIHM> liste)
	{
		for(int i=0;i<liste.size();i++)
		{
			for(int j=0;j<liste.get(i).getList().size();j++)
			{
				
				Coord coordPiece = liste.get(i).getList().get(j);
				int position = coordPiece.y*8 + coordPiece.x;
				
				 Couleur color = liste.get(i).getCouleur();
				 String typePiece = liste.get(i).getTypePiece();
				
				JLabel piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile(typePiece, color)));
				JPanel panel = (JPanel)chessBoard.getComponent(position);
				panel.removeAll();
				panel.add(piece);
				
			}
			
		}
	}
	
	public void checkMove(Coord coord)
	{
		
	}
	
	public static final int getComponentIndex(Component component) {
		if (component != null && component.getParent() != null) {
			Container c = component.getParent();
			for (int i = 0; i < c.getComponentCount(); i++) {
				if (c.getComponent(i) == component)
					return i;
			}
		}

		return -1;
	}

}
