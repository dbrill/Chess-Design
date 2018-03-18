package ChessDesign;

import java.util.Scanner;

/**
 * @author Abhijit on 3/17/2018
 * Main class
 */

public class ChessGame {

	public static void main(String[] args) {
		
		//DisplayBoard.displayBoard();
		
		Scanner sc = new Scanner(System.in); 
		
		Board.getInstance().createBoard();
		
		Board.getInstance().createPlayers();
		
		DisplayBoard.displayInstructions();
		DisplayBoard.displayGraphicBoard();
		
		boolean whiteCheckmate = false;
		boolean blackCheckmate = false;
		
		while(true) {
			
			Player currentTurn = Board.getInstance().currentTurn;
			String move = "";
			
			if(currentTurn.color == Color.WHITE) {
				
				System.out.print("White Player turn: ");
			}
			else if(currentTurn.color == Color.BLACK){
				
				System.out.print("Black Player turn: ");
			}
			
			move = sc.nextLine();
			
			
			//See for Check mate
			whiteCheckmate = Board.getInstance().whiteCheckmate();
			blackCheckmate = Board.getInstance().blackCheckmate();
			
			if(whiteCheckmate && blackCheckmate)
				break;
			
			//TODO: See for check moves
			
			
			
			Board.getInstance().changeTurn();
			System.out.println();
			
		}
	}

}
