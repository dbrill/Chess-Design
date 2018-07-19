package Pieces;

import ChessDesign.Color;
import ChessDesign.Player;
import ChessDesign.Board;

/**
 * @author Abhijit on 3/17/2018
 *
 */
public class Pawn extends Piece{
	Boolean firstMove;
	/***
	 * Refer constructor of Piece
	 * @param player
	 * @param x
	 * @param y
	 */
	public Pawn(Player player, int x, int y) {
		super(Type.PAWN, player, x, y);

		this.firstMove = true;
		this.displayText += "P";
	}

	@Override
	public boolean movement_type(int fx, int fy) {
		int distance = 1;

		if(this.firstMove)
			distance ++;

		if(Math.abs(this.x - fx) > distance){
			System.out.println("You can't move that far!");
			return false;
		}

		if(this.x > fx){
			if(this.player.color == Color.BLACK){
				System.out.println("Pawns can't move backwards!");
				return false;
			}
		}
		else if (this.x < fx){
			if(this.player.color == Color.WHITE){
				System.out.println("Pawns can't move backwards!");
				return false;
			}
		}

		//if taking a piece
		if(this.y != fy){
			if((Board.getInstance().board[fx][fy] == null)
					|| (Board.getInstance().board[fx][fy].player == this.player)
					|| (this.x == fx)
					|| (Math.abs(this.y - fy) > 1)){
				System.out.println("Pawns can't move that way!");
				return false;
			}
		}
		else if(Board.getInstance().board[fx][fy] != null){
			System.out.println("There's a piece in your way!");
			return false;
		}

		this.firstMove = false;
		return true;
	}

}
