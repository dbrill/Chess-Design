package ChessDesign;
import Pieces.Piece;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Abhijit
 *
 */
public class BoardView extends JFrame {
	public CButton[][] spaces;
	public static BoardView boardViewObj;

	public Controller controller = new Controller();
	/**
	 * Displays the Graphic Chess board with pieces
	 */
	public BoardView() {
		boardViewObj = this;
		Piece[][] tempBoard = Board.getInstance().board;
		spaces = new CButton[8][8];

		setSize(800,800);
		setLocation(50,80);
		setBackground(java.awt.Color.DARK_GRAY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(8, 8));
		setTitle("Janky Chess!");
		System.out.print("  ");

		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(tempBoard[i][j] != null){
					spaces[i][j] = new CButton(tempBoard[i][j], i, j);
				}
				else{
					spaces[i][j] = new CButton(i, j);
				}
				add(spaces[i][j]);
				spaces[i][j].setBorder(new EtchedBorder(EtchedBorder.LOWERED));
				spaces[i][j].addActionListener(controller);
			}
		}
		setVisible(true);
	}

	public static BoardView getInstance(){
		if(boardViewObj == null)
			boardViewObj = new BoardView();
		return boardViewObj;
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
		
		System.out.println("Click the piece you wish to move");
		System.out.println("This currently selected piece will be highlighted");
		System.out.println("Choose the destination you wish to move to");
		System.out.println("\nIf you select an invalid move your turn starts over!\n");
	}

}
