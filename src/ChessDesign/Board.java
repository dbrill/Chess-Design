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
	
	private Player white;
	private Player black;
	
	public Player currentTurn;
	
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
	
	/**
	 * Create players White and Black
	 */
	public void createPlayers() {
		
		white = new Player(Color.WHITE);
		white.initializePieces();
		currentTurn = white;
		
		black = new Player(Color.BLACK);
		black.initializePieces();
	}
	
	/**
	 * Changing the turn after each move
	 */
	public void changeTurn() {
		
		if(currentTurn == white) {
			
			currentTurn = black;
		}
		else if(currentTurn == black){
			
			currentTurn = white;
		}
	}
	
	/**
	 * Method to check if White has a check on Black
	 * @return True if its a check, else false
	 */
	public boolean whiteCheck() {
		return false;
	}
	
	/**
	 * Method to check if Black has a check on White
	 * @return True if its a check, else false
	 */
	public boolean blackCheck() {
		return false;
	}
	
	/**
	 * Method to check if White has a Checkmate on Black
	 * @return True if its a Checkmate, else false
	 */
	public boolean whiteCheckmate() {
		return false;
	}
	
	/**
	 * Method to check if Black has a Checkmate on White
	 * @return True if its a Checkmate, else false
	 */
	public boolean blackCheckmate() {
		return false;
	}
		

}
