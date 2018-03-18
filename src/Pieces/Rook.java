/**
 * 
 */
package Pieces;

import ChessDesign.Player;

/**
 * @author Abhijit on 3/17/2018
 *
 */
public class Rook extends Piece{

	/***
	 * Refer constructor of Piece
	 * @param player
	 * @param x
	 * @param y
	 */
	public Rook(Player player, int x, int y) {
		super(Type.ROOK, player, x, y);
		
		this.displayText += "R";
	}

	@Override
	public void movement_type(int fx, int fy) {
		// TODO Auto-generated method stub
		
	}

}
