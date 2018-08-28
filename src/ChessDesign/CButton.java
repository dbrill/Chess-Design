package ChessDesign;
import Pieces.Piece;
import javax.swing.*;
import java.awt.Color;

public class CButton extends JButton  {
    Piece piece;
    int x;
    int y;

    public CButton(Piece piece, int x, int y){
        super(piece.displayText);
        this.piece = piece;
        this.x = x;
        this.y = y;
    }
    public CButton(int x, int y){
        super("");
        this.x = x;
        this.y = y;
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
    }
}