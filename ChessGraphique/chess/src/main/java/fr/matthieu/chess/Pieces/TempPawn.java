package fr.matthieu.chess.pieces;

public class TempPawn extends Piece{
    protected Piece copy;

    public TempPawn (int x, int y, Piece piece) {
        super.mX = x;
        super.mY = y;
        super.mSide = piece.getSide();
        super.mType = "Passing";
        this.copy = piece;
    }


    public Piece getCopy() {
        return this.copy;
    }

    public void setCopy(Piece copy) {
        this.copy = copy;
    }
    
}
