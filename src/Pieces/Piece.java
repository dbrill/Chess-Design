package Pieces;
import ChessDesign.*;

/**
 * @author Abhijit
 *
 */
public abstract class Piece {
	
	Type type;
	Player player;
	int x;
	int y;
	
	public String displayText;		//For display purpose only
	
	/***
	 * 
	 * @param type		Type of Piece (of Type enum)
	 * @param player	Player associated with this piece
	 * @param x			Current X position
	 * @param y			Current Y position
	 */
	public Piece(Type type, Player player, int x, int y) {
		
		this.type = type;
		this.player = player;
		this.x = x;
		this.y = y;
		
		if(player.color == Color.WHITE)
			displayText = "W.";
		else
			displayText = "B.";
			
		
		Board.getInstance().board[x][y] = this;	
	}
	
	/***
	 * 
	 * @param final_x	Next move's X position
	 * @param final_y	Next move's Y position
	 * @return			Returns if player can move piece to final_x,final_y
	 */
	//TODO:Implement this method in the Piece class
	public boolean movement(int final_x, int final_y) {
		
		
		
		return false;
		
	}
	
	//TODO: Implement this method in all piece children class
	public abstract void movement_type(int fx, int fy);
}
