/**
 * 
 */
package ChessDesign;

/**
 * @author Abhijit on 3/17/2018
 *
 */
public class DisplayBoard {
	
	DisplayBoard(){
		
	}
	
	public static void displayBoard() {
		
		System.out.print("  ");
		
		for(int j=0; j<8; j++) {
			System.out.print("______");
		}
		System.out.println();
		
		for(int i=7; i>= 0; i--) {
			
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
