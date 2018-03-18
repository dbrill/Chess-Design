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
	}

}
