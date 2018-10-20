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
	
	/**
	 * Returns the Player associated to this piece
	 * @return Player object
	 */
	public Player getPlayer() {
		return player;
	}
	
	/***
	 * 
	 * @param final_x	Next move's X position
	 * @param final_y	Next move's Y position
	 * @return			Returns if player can move piece to final_x,final_y
	 */
	//TODO:Implement this method in the Piece class
	public boolean movement(int final_x, int final_y) {

		if(player != Board.getInstance().currentTurn) {
			System.out.println("You can't move someone else's piece!");
			return false;    //Cannot access the other player's piece
		}

		if(!Board.isValidSpace(final_x, final_y)){
			System.out.println("Move is outside the board!");
			return false;
		}

		if(this.x == final_x && this.y == final_y){
		    System.out.println("You've gotta move somewhere!");
		    return false;
        }

		if((Board.getInstance().board[final_x][final_y] != null)
                && (Board.getInstance().board[final_x][final_y].player == Board.getInstance().currentTurn)) {
			System.out.println("You can't move over your own piece!");
			return false;
		}
		
		if(movement_type(final_x, final_y)) {
			updateBoard(final_x, final_y);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Once the piece is confirmed to move from x,y to fx,fy; This function updates the board
	 * @param fx Final X position
	 * @param fy Final Y position
	 */
	public void updateBoard(int fx, int fy) {
		
		Board.getInstance().board[fx][fy] = this;
		Board.getInstance().board[x][y] = null;
		Board.getInstance().changeTurn();

		
		this.x = fx;
		this.y = fy;
	}


	//TODO: Implement this method to make sure you get your king out of jeopardy if it's in check
	public Boolean inCheck(){
		return true;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public Type getType() { return this.type; }
	//TODO: Implement this method in all piece children class + Delete piece if present in fx,fy
	public abstract boolean movement_type(int fx, int fy);
}
