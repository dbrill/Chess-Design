package Pieces;

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

	@Override
	public void movement_type(int fx, int fy) {
		// TODO Auto-generated method stub
		
	}

}
