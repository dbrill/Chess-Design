package ChessDesign;
import Pieces.Piece;
import javax.swing.*;

public class CButton extends JButton  {
    Piece piece;

    public CButton(Piece piece){
        super(piece.displayText);
        this.piece = piece;
    }
    public CButton(){
        super("");
    }
}