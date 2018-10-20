/**
 * 
 */
package Pieces;

import ChessDesign.Board;
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

	private boolean isPathClear(int fx, int fy) {

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

	@Override
	public boolean movement_type(int fx, int fy) {
		if(!isPathClear(fx, fy))
		    return false;

		if(this.x != fx && this.y != fy){
		    System.out.println("Rooks can only move in one direction at a time!");
		    return false;
        }
		return true;
	}

}
