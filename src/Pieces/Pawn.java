package Pieces;

import ChessDesign.Player;

/**
 * @author Abhijit on 3/17/2018
 *
 */
public class Pawn extends Piece{

	/***
	 * Refer constructor of Piece
	 * @param player
	 * @param x
	 * @param y
	 */
	public Pawn(Player player, int x, int y) {
		super(Type.PAWN, player, x, y);
		
		this.displayText += "P";
	}

	@Override
	public boolean movement_type(int fx, int fy) {
		// TODO Auto-generated method stub
		
		return true;
		
	}

}
