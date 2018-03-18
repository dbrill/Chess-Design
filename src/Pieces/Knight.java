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
	public void movement_type(int fx, int fy) {
		// TODO Auto-generated method stub
		
	}

}
