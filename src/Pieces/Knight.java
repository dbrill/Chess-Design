package Pieces;

import ChessDesign.Player;

/**
 * @author Abhijit on 3/17/2018
 *
 */
public class Knight extends Piece{

	/***
	 * Refer constructor of Piece
	 * @param player
	 * @param x
	 * @param y
	 */
	public Knight(Player player, int x, int y) {
		super(Type.KNIGHT, player, x, y);
		
		this.displayText += "H";
	}

	@Override
	public boolean movement_type(int fx, int fy) {
		if(Math.abs(this.x - fx) == 2 && Math.abs(this.y - fy) == 1){
			return true;
		}
		else if(Math.abs(this.x - fx) == 1 && Math.abs(this.y - fy) == 2){
			return true;
		}
		else{
			return false;
		}
	}

}
