package ChessDesign;
import Pieces.*;

/**
 * @author Abhijit
 *
 */

//Singleton Class

public class Board {
	
	private static Board boardObj;
	public Piece[][] board;
	
	public Board() {
		
	}
	
	/**
	 * Implementing the Singleton design for board
	 * @return singleton instance object
	 */
	public static Board getInstance() {
		
		if(boardObj == null)
			boardObj = new Board();
		
		return boardObj;
	}
	
	/**
	 * Creating a Chess Board. Must be called just once
	 */
	public void createBoard() {
		board = new Piece[8][8];
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				board[i][j] = null;
			}
		}
	}
	
	

}
