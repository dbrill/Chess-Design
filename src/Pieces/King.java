package Pieces;

import ChessDesign.Player;

/**
 * @author Abhijit on 3/17/2018
 *
 */
public class King extends Piece{

	/***
	 * Refer constructor of Piece
	 * @param player
	 * @param x
	 * @param y
	 */
	public King(Player player, int x, int y) {
		super(Type.QUEEN, player, x, y);
		
	}

	@Override
	public void movement_type(int fx, int fy) {
		// TODO Auto-generated method stub
		
	}

}
