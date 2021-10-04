package fr.matthieu.chess.pieces;

public class TempPawn extends Piece{
    protected Piece copy;

    public TempPawn (int x, int y, Piece piece) {
        super.x = x;
        super.y = y;
        super.side = piece.getSide();
        super.type = "Passing";
        this.copy = piece;
    }


    public Piece getCopy() {
        return this.copy;
    }

    public void setCopy(Piece copy) {
        this.copy = copy;
    }
    
}
