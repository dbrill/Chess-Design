package ChessDesign;

import java.util.Scanner;
import Pieces.*;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * @author Abhijit on 3/17/2018
 * Main class
 */

public class ChessGame {

	public static void main(String[] args) {
		
		//DisplayBoard.displayBoard();
		
		Scanner sc = new Scanner(System.in);

		//* GUI STUFF *//
//		JButton tz = new JButton("woopity doo!");
//		JButton gz = new JButton("Anotha one");
//		tz.setPreferredSize(new java.awt.Dimension(100, 100));
//		gz.setPreferredSize(new java.awt.Dimension(100, 100));
//		tz.setLocation(0, 0);
//		gz.setLocation(600, 600);
//
//		JFrame window = new JFrame("swing test");
//		window.setBackground(java.awt.Color.BLUE);
//		window.setSize(new java.awt.Dimension(600, 600));
//		window.setResizable(false);
//		window.setLocale(null);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.add(tz);
//
//		JFrame windowt = new JFrame("swing test");
//		windowt.setBackground(java.awt.Color.BLUE);
//		windowt.setSize(new java.awt.Dimension(600, 600));
//		windowt.setResizable(false);
//		windowt.setLocale(null);
//		windowt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		windowt.add(gz);
//
//		windowt.pack();
//		window.pack();
//		window.setVisible(true);
//		windowt.setVisible(true);

//		tz.updateUI();
		
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
				
				System.out.print("White Player's turn: ");
			}
			else if(currentTurn.color == Color.BLACK){
				
				System.out.print("Black Player's turn: ");
			}
			
			move = sc.nextLine();
			
			if(!decodeMove(move)) {
				
				System.out.println("Status: Not a valid move. Please try again\n");
				continue;
			}				
			else {
				
				System.out.println("Status: Great Move");
				DisplayBoard.displayGraphicBoard();
			}
			
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
	
	/**
	 * Check if the move is valid or not
	 * @param move	Input string from the player
	 * @return	True if valid move, else False
	 */
	public static boolean decodeMove(String move) {
		
		move = move.trim();
		move = move.toUpperCase();
		
		String[] parts = move.split("\\s");
		
		if(parts.length != 5)	
			return false;		//Not a proper format
		
		if(!parts[1].equals("FROM") || !parts[3].equals("TO"))
			return false;		//There is no To and From
		
		String piece = parts[0];
		String from = parts[2];
		String to = parts[4];
		
		int[] initialPos;
		int[] finalPos;
		
		if(from.length() != 2 || !Character.isAlphabetic(from.charAt(0)) || !Character.isDigit(from.charAt(1))) {
			return false;	//From string is not good
		}else {
			initialPos = decodePosition(from);
		}
		
		if(to.length() != 2 || !Character.isAlphabetic(to.charAt(0)) || !Character.isDigit(to.charAt(1))) {
			return false;	//To string is not good
		}else {
			finalPos = decodePosition(to);
		}
		
		if(piece.length() != 1 || !Character.isAlphabetic(piece.charAt(0))) {
			return false;	//Piece string is not good
		}
		else {
			
			Piece m_piece = Board.getInstance().board[initialPos[0]][initialPos[1]];
			
			if(m_piece == null)
				return false;	//No piece at To position
			else {
				return m_piece.movement(finalPos[0], finalPos[1]);		//Main function call to move the piece or not
			}
			
		}
	}
	
	/**
	 * Decodes the input position to matrix position
	 * @param pos	Input position (String. example C5)
	 * @return	int[2] That is x,y index in board[][] matrix
	 */
	public static int[] decodePosition(String pos) {
		
		int[] p = new int[2];
		
		p[0] = pos.charAt(1) - '0' - 1;
		p[1] = pos.charAt(0) - 'A';
		
		return p;
	}

}
