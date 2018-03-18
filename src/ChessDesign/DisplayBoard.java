package ChessDesign;
import Pieces.Piece;

/**
 * @author Abhijit
 *
 */
public class DisplayBoard {
	
	DisplayBoard(){
		
	}
	
	/**
	 * Displaying the Board 2D matrix. (For test purpose)
	 */
	public static void displayBoard() {
		
		Piece[][] tempBoard = Board.getInstance().board;
		
		for(int i=0; i < 8; i++) {
			for(int j=0; j < 8; j++) {
				System.out.print(tempBoard[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Displays the Graphic Chess board with pieces
	 */
	public static void displayGraphicBoard() {
		
		Piece[][] tempBoard = Board.getInstance().board;
		
		System.out.print("  ");
		
		for(int j=0; j<8; j++) {
			System.out.print("______");
		}
		System.out.println();
		
		for(int i=0; i < 8; i++) {
			
			System.out.print("  |");
			
			for(int x=0; x<8; x++) {
				System.out.print("     |");
			}
			
			System.out.println();
			//Printing the vertical numbers 8-1
			System.out.print(i+1 + " |");
			
			//TODO: Insert chess piece here, in this below loop
			for(int y=0; y<8; y++) {
				//System.out.print("     |");
				
				if(tempBoard[i][y] != null) {
					System.out.print(" "+tempBoard[i][y].displayText+ " |");
				}
				else
					System.out.print("     |");
				//System.out.print(" W.Q |");
			}
			
			System.out.println();
			System.out.print("  |");
			
			for(int z=0; z < 8; z++) {
				
				System.out.print("_____|");
			}
			System.out.println();
			
			
		}
		
		System.out.print("   ");
		//printing the horizontal alphabets
		char a = 'A';
		for(int j=0; j<8; j++) {
			System.out.print("  "+a+"   ");
			a++;
		}
		System.out.println("\n");
	}
	
	public static void displayInstructions() {
		System.out.println("\n ------- INSTRUCTIONS ------- \n");
		System.out.println("Each player is either White (W) or Black(B)\n");
		
		System.out.println("Here is the following index for chess pieces");
		System.out.println("    Pawn -> P");
		System.out.println("    Rook -> R");
		System.out.println("    Knight -> H");
		System.out.println("    Bishop -> B");
		System.out.println("    Queen -> Q");
		System.out.println("    King -> K\n");
		
		System.out.println("Wait for the chess master to mention the Player's turn");
		System.out.println("To make a move, Follow the syntax and type the move");
		
		System.out.println("Syntax: <PieceName> <Alphabet><Number> to <Alphabet><Number>");
		System.out.println("If its White player's turn, \nExample: Type P C3 to C5");
		System.out.println("~ This will White's Pawn from C3 to C5 (If its not a valid move, the Master given another turn)");
		
		System.out.println("\n");
	}

}
