/**
 * 
 */
package Pieces;
import ChessDesign.Board;
import ChessDesign.Player;

/**
 * @author Abhijit
 *
 */
public class Bishop extends Piece{

	/***
	 * Refer constructor of Piece
	 * @param player
	 * @param x
	 * @param y
	 */
	public Bishop(Player player, int x, int y) {
		super(Type.BISHOP, player, x, y);
		
		this.displayText += "B";
	}

	@SuppressWarnings("Duplicates")
	public Boolean isPathClear(int fx, int fy){
		int incx = 1;
		int incy = 1;
		if(fx < this.x)
			incx = -1;
		if(fy < this.y)
			incy = -1;

		for(int i = 1; i != Math.abs(this.x - fx); i++){
			if(Board.getInstance().board[this.x + (i * incx)][this.y + (i * incy)] != null){
				System.out.println("There's a piece in your way!");
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean movement_type(int fx, int fy) {
		if(Math.abs(this.x - fx) != Math.abs(this.y - fy)){
			System.out.println("Bishop must move diagonally!");
			return false;
		}

		if(!isPathClear(fx, fy))
			return false;

		return true;
	}

}
