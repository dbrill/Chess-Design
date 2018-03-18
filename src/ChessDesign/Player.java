package ChessDesign;
import Pieces.*;

/**
 * @author Abhijit
 *
 */

public class Player {
	
	public Color color;
	
	Pawn[] pawns;
	Queen queen;
	King king;
	Bishop[] bishop;
	Rook[] rook;
	Knight[] knight;
	
	//Temporary variable for x positions
	private int initialX;
	
	/***
	 * 
	 * @param color Player type
	 */
	public Player(Color color) {
		
		this.color = color;
		if(color == Color.WHITE)
			initialX = 6;
		else
			initialX = 1;
	}
	
	/**
	 * Initializing the Pieces for each Player
	 */
	public void initilizePieces() {
		
		//Creating Pawns
		pawns = new Pawn[8];
		for(int i=0; i<8; i++) {
			pawns[i] = new Pawn(this, initialX, i);
		}
		
		if(color == Color.WHITE)
			initialX += 1;
		else
			initialX -= 1;
		
		rook = new Rook[2];
		rook[0] = new Rook(this, initialX, 0);
		rook[1] = new Rook(this, initialX, 7);
		
		knight = new Knight[2];
		knight[0] = new Knight(this, initialX, 1);
		knight[1] = new Knight(this, initialX, 6);
		
		bishop = new Bishop[2];
		bishop[0] = new Bishop(this, initialX, 2);
		bishop[1] = new Bishop(this, initialX, 5);
		
		queen = new Queen(this, initialX, 3);
		king = new King(this, initialX, 4);
				
	}

}
