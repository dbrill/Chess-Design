package Pieces;

import ChessDesign.Player;
import ChessDesign.Board;


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
		super(Type.KING, player, x, y);
		
		this.displayText += "K";
	}

	@Override
	public boolean movement_type(int fx, int fy) {
		if(Math.abs(this.x - fx) > 1 || Math.abs(this.y - fy) > 1){
			System.out.println("Kings can only move one space at a time!");
			return false;
		}

		//TODO check to make sure king isn't moving into check(mate)
		if(!Board.spaceIsSafe(fx, fy, this.player)){
			System.out.println("You can't move your king into jeopardy!");
			return false;
		}
		return true;
	}

}
