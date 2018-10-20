package ChessDesign;
import Pieces.*;

import javax.swing.*;
import java.security.InvalidParameterException;

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
			if(whiteCheckmate()){
				JOptionPane.showMessageDialog(null, "{*} !!Black wins!! {*}");
				System.exit(0);
			}
			if(blackCheckmate()){
				JOptionPane.showMessageDialog(null, "{*} !!White wins!! {*}");
				System.exit(0);
			}
			if(blackCheck()){
				JOptionPane.showMessageDialog(null, "Black is in check!");
			}
			if(whiteCheck()){
				JOptionPane.showMessageDialog(null, "White is in check!");
			}
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
	 * Method to check if a space is within the constraints of the board
	 * Helper for check(mate) functions
	 * @return True if valid space, false if not
	 */
	public static boolean isValidSpace(int x, int y) {
		if (x < 0 || y < 0){
			return false;
		}
		if (x > 7 || y > 7){
			return false;
		}
		else{
			return true;
		}
	}

	/**
	 * Get player's king for check(mate) purposes
	 * @input either "white" or "black"
	 * @return the requested player
	 */
	public Player getPlayers(String player) throws InvalidParameterException {

		if (player.toLowerCase() == "white"){
			return white;
		}
		else if (player.toLowerCase() == "black"){
			return black;
		}
		else{
			throw new InvalidParameterException("You need to input white or black!");
		}
	}
	/**
	 * Method to see if space puts a piece in jeopardy
	 * Implementing this as an isolated method is more extensible
	 * than implementing the same logic in whiteCheck or blackCheck
	 * because we can use it to see if this is a valid move for the king
	 * @input the space to check and the player who is moving
	 * @return True if the space is safe, False if otherwise
	 *
	 * @note this method is super ineffecient. I should find a way to break it up!
	 */
	@SuppressWarnings("Duplicates")
	public static boolean spaceIsSafe(int x, int y, Player player){
		Board board = Board.getInstance();

		//check for rooks and queens
		//check up
		for(int i = 1; x - i >= 0; i++){
			System.out.println(x-i);
			System.out.println(y);
			Piece piece = board.board[x - i][y];
			if(piece != null && piece.getPlayer() != player){
				if(piece.getType() == Type.ROOK || piece.getType() == Type.QUEEN){
					return false;
				}
			}
			else if (piece != null && piece.getPlayer() == player){
				break;
			}
		}
		//check down
		for(int i = 1; x + i <= 7; i++){
			Piece piece = board.board[x + i][y];
			if(piece != null && piece.getPlayer() != player){
				if(piece.getType() == Type.ROOK || piece.getType() == Type.QUEEN){
					return false;
				}
			}
			else if (piece != null && piece.getPlayer() == player){
				break;
			}
		}
		//check right
		for(int i = 1; y + i <= 7; i++){
			Piece piece = board.board[x][y + i];
			if(piece != null && piece.getPlayer() != player){
				if(piece.getType() == Type.ROOK || piece.getType() == Type.QUEEN){
					return false;
				}
			}
			else if (piece != null && piece.getPlayer() == player){
				break;
			}
		}
		//check left
		for(int i = 1; y - i >= 0; i++){
			Piece piece = board.board[x][y - i];
			if(piece != null && piece.getPlayer() != player){
				if(piece.getType() == Type.ROOK || piece.getType() == Type.QUEEN){
					return false;
				}
			}
			else if (piece != null && piece.getPlayer() == player){
				break;
			}
		}

		//check for bishops and queens
		//check up-left
		for(int i = 1; x - i >= 0 && y - i >= 0; i ++){
			Piece piece = board.board[x-i][y-i];
			if(piece != null && piece.getPlayer() != player){
				if(piece.getType() == Type.BISHOP || piece.getType() == Type.QUEEN){
					return false;
				}
			}
			else if (piece != null && piece.getPlayer() == player){
				break;
			}
		}

		//check up-right
		for(int i = 1; x - i >= 0 && y + i <= 7; i ++){
			Piece piece = board.board[x-i][y+i];
			if(piece != null && piece.getPlayer() != player){
				if(piece.getType() == Type.BISHOP || piece.getType() == Type.QUEEN){
					return false;
				}
			}
			else if (piece != null && piece.getPlayer() == player){
				break;
			}
		}

		//check down-left
		for(int i = 1; x + i <= 7 && y - i >= 0; i ++){
			Piece piece = board.board[x+i][y-i];
			if(piece != null && piece.getPlayer() != player){
				if(piece.getType() == Type.BISHOP || piece.getType() == Type.QUEEN){
					return false;
				}
			}
			else if (piece != null && piece.getPlayer() == player){
				break;
			}
		}

		//check down-right
		for(int i = 1; x + i <= 7 && y + i <= 7; i ++){
			Piece piece = board.board[x+i][y+i];
			if(piece != null && piece.getPlayer() != player){
				if(piece.getType() == Type.BISHOP || piece.getType() == Type.QUEEN){
					return false;
				}
			}
			else if (piece != null && piece.getPlayer() == player){
				break;
			}
		}
		//check for pawns
		if (player.color == Color.WHITE){
			if (x > 0){
				if(y > 0) {
					if (board.board[x - 1][y-1] != null &&
							board.board[x - 1][y-1].getPlayer() != player &&
							board.board[x - 1][y-1].getType() == Type.PAWN) {
						return false;
					}
				}
				if(y < 7){
					if (board.board[x - 1][y + 1] != null &&
							board.board[x - 1][y+1].getPlayer() != player &&
							board.board[x - 1][y+1].getType() == Type.PAWN) {
						return false;
					}
				}
			}
		}
		else{
			if (x < 7){
				if(y > 0) {
					if (board.board[x + 1][y - 1] != null &&
							board.board[x + 1][y-1].getPlayer() != player &&
							board.board[x + 1][y-1].getType() == Type.PAWN) {
						return false;
					}
				}
				if(y < 7){
					if (board.board[x + 1][y + 1] != null &&
							board.board[x + 1][y+1].getPlayer() != player &&
							board.board[x + 1][y+1].getType() == Type.PAWN) {
						return false;
					}
				}
			}
		}
		//check for kings
		int[][] directions = new int[][]{{-1,-1}, {-1,0}, {-1,1},  {0,1}, {1,1},  {1,0},  {1,-1},  {0, -1}};
		for(int i = 0; i < directions.length; i++){
			int tempX = x + directions[i][0];
			int tempY = y + directions[i][1];
			if (tempX < 0 ||
				tempY < 0 ||
				tempX > 7 ||
				tempY > 7){
				continue;
			}
			else{
				if (board.board[tempX][tempY] != null &&
						board.board[tempX][tempY].getPlayer() != player &&
						board.board[tempX][tempY].getType() == Type.KING){
					return false;
				}
			}
		}

		//check for knights
		directions = new int[][]{{-2,-1}, {-2,1}, {2,-1},  {2,1}, {1,-2},  {1,2},  {-1,-2},  {-1, 2}};
		for(int i = 0; i < directions.length; i++){
			int tempX = x + directions[i][0];
			int tempY = y + directions[i][1];
			if (tempX < 0 ||
					tempY < 0 ||
					tempX > 7 ||
					tempY > 7){
				continue;
			}
			else{
				if (board.board[tempX][tempY] != null &&
						board.board[tempX][tempY].getPlayer() != player &&
						board.board[tempX][tempY].getType() == Type.KNIGHT){
					return false;
				}
			}
		}
		return true;
	}


	/**
	 * Method to check if White is in check
	 * @return True if its a check, else false
	 */
	public boolean whiteCheck() {
		int[] kingSpace = new int[]{white.king.getX(), white.king.getY()};
		return !spaceIsSafe(kingSpace[0], kingSpace[1], white);
	}
	
	/**
	 * Method to check if Black is in check
	 * @return True if its a check, else false
	 */
	public boolean blackCheck() {
		int[] kingSpace = new int[]{black.king.getX(), black.king.getY()};
		System.out.println("Checking if black king is in check at: " + kingSpace[0] + kingSpace[1]);
		return !spaceIsSafe(kingSpace[0], kingSpace[1], black);
	}
	
	/**
	 * Method to check if White is in Checkmate
	 * @return True if its a Checkmate, else false
	 */
	@SuppressWarnings("Duplicates")
	public boolean whiteCheckmate() {
		if(!whiteCheck()){
			return false;
		}
		int[] kingSpace = new int[]{white.king.getX(), white.king.getY()};
		int[][] directions = new int[][]{{-1,-1}, {-1,0}, {-1,1},  {0,1}, {1,1},  {1,0},  {1,-1},  {0, -1}};
		for(int i = 0; i < directions.length; i++){
			int tempX = kingSpace[0] + directions[i][0];
			int tempY = kingSpace[1] + directions[i][1];
			if (tempX < 0 ||
					tempY < 0 ||
					tempX > 7 ||
					tempY > 7){
				continue;
			}
			if(spaceIsSafe(tempX, tempY, white)){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Method to check if Black is in Checkmate
	 * @return True if its a Checkmate, else false
	 */
	@SuppressWarnings("Duplicates")
	public boolean blackCheckmate() {
		if(!blackCheck()){
			return false;
		}
		int[] kingSpace = new int[]{black.king.getX(), black.king.getY()};
		int[][] directions = new int[][]{{-1,-1}, {-1,0}, {-1,1},  {0,1}, {1,1},  {1,0},  {1,-1},  {0, -1}};
		for(int i = 0; i < directions.length; i++){
			int tempX = kingSpace[0] + directions[i][0];
			int tempY = kingSpace[1] + directions[i][1];
			if (tempX < 0 ||
					tempY < 0 ||
					tempX > 7 ||
					tempY > 7){
				continue;
			}
			if(spaceIsSafe(tempX, tempY, black)){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args){
		Board.getInstance().createBoard();

		Board.getInstance().createPlayers();
		BoardView boardView = new BoardView();

		boardView.displayInstructions();
	}

}
