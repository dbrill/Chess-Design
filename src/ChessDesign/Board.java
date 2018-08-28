package ChessDesign;
import Pieces.*;

/**
 * @author Abhijit  @modifier Dbrill
 *
 */

//Singleton Class

public class Board {
	
	private static Board boardObj;
	// This is a good example of polymorphism. The 2D array type is generically "Piece" so that we
	// can store all kinds of pieces in the board object.
	public Piece[][] board;

	public int[][] move = new int[2][2];
	
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

	public Boolean makeMove(Piece piece, int fx, int fy) {
		int oldx = piece.getX();
		int oldy = piece.getY();
		if(piece.movement(fx, fy)){
			System.out.println("Moving: " + piece.displayText + " to " + fx + ", " + fy);
			updateBoardView(piece, oldx, oldy);
			return true;
		}
		else{
			return false;
		}
	}

	public void updateBoardView(Piece piece, int x, int y){
		BoardView.getInstance().spaces[x][y].piece = null;
		BoardView.getInstance().spaces[x][y].setText("");
		BoardView.getInstance().spaces[piece.getX()][piece.getY()].piece = piece;
		BoardView.getInstance().spaces[piece.getX()][piece.getY()].setText(piece.displayText);
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

	public static void main(String[] args){
		Board.getInstance().createBoard();

		Board.getInstance().createPlayers();
		BoardView boardView = new BoardView();

		boardView.displayInstructions();
	}

}
