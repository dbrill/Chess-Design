package Pieces;

import ChessDesign.Board;
import ChessDesign.Player;

/**
 * @author Abhijit on 3/17/2018
 *
 */
public class Queen extends Piece{

	/***
	 * Refer constructor of Piece
	 * @param player
	 * @param x
	 * @param y
	 */
	public Queen(Player player, int x, int y) {
		super(Type.QUEEN, player, x, y);
		
		this.displayText += "Q";
	}

	private Boolean isDiagonal(int fx, int fy){
		if(Math.abs(this.x - fx) != Math.abs(this.y - fy)){
			return false;
		}
		else{
			return true;
		}
	}

	private Boolean isStraight(int fx, int fy){
		if(this.x != fx && this.y != fy){
			return false;
		}
		return true;
	}

	@SuppressWarnings("Duplicates")
	public boolean isStraightClear(int fx, int fy) {

		int inc = 1;

		if (this.y != fy) {
			if (fy < this.y)
				inc = -1;

			for (int i = this.y + inc; i != fy; i = i + inc) {
				if (Board.getInstance().board[fx][i] != null) {
					System.out.println("There's a piece in your way!");
					return false;
				}
			}
		} else if (this.x != fx) {
			if (fx < this.x)
				inc = -1;
			for (int i = this.x + inc; i != fx; i = i + inc){
				if (Board.getInstance().board[i][fy] != null){
					System.out.println("There's a piece in your way!");
					return false;
				}
			}
		}
		return true;
	}

	@SuppressWarnings("Duplicates")
	public Boolean isDiagonalClear(int fx, int fy){
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
		if (isDiagonal(fx, fy)){
			if (! isDiagonalClear(fx, fy)){
				return false;
			}
		}
		else if (isStraight(fx, fy)){
			if (! isStraightClear(fx, fy)){
				return false;
			}
		}
		else{
			System.out.println("Queens have to move straight or diagonally!");
			return false;
		}
		return true;
	}

}
