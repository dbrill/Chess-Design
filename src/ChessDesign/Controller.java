package ChessDesign;
import Pieces.Piece;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
    private CButton selected = null;

    public void actionPerformed(ActionEvent ae){
        CButton clicked = (CButton) ae.getSource();
        if(this.selected == null){
            if(clicked.piece != null){
                this.selected = clicked;
                selected.setBackground(Color.GREEN);
            }
            else{
                System.out.println("You need to selected a piece!");
            }
        }
        else{
            Board.getInstance().makeMove(selected.piece, clicked.x, clicked.y);
            selected.setBackground(null);
            selected = null;
        }
    }
}
