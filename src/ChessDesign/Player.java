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
	private boolean inCheck = false;
	
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
	public void initializePieces() {
		
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

	/**
	 * A helper function to return the space that the player's king currently occupies
	 * This will be used in the check(mate) functions
	 * @return an array of two ints [x, y]
	 */
	public int[] getKing(){
		int[] kingSpace = new int[]{king.getX(), king.getY()};
		return kingSpace;
	}

	public void setCheck(){
		this.inCheck = true;
	}
	public void unsetCheck() {this.inCheck = false; }
	public boolean inCheck() {return this.inCheck;}

}
