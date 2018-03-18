package ChessDesign;

/**
 * @author Abhijit on 3/17/2018
 * Main class
 */

public class ChessGame {

	public static void main(String[] args) {
		
		//DisplayBoard.displayBoard();
		
		Board.getInstance().createBoard();
		
		Player white = new Player(Color.WHITE);
		white.initilizePieces();
		
		Player black = new Player(Color.BLACK);
		black.initilizePieces();
		
		DisplayBoard.displayGraphicBoard();
	}

}
