package fr.matthieu.chess.board;


import fr.matthieu.chess.pieces.Piece;
import fr.matthieu.utils.Utils;

public class Case {
    protected int           mX;
    protected int           mY;
    protected boolean       mColor;
    protected Piece         mPiece;
    protected boolean       mIsEmpty = true;
    protected StringBuilder mContent;

    public Case(int x, int y, Piece piece) {
        this.mX = x;
        this.mY = y;
        this.mPiece = piece;
        if ((x % 2 == 0 && y % 2 != 0) || (x % 2 != 0 && y % 2 == 0)) {
            // this.mContent = new StringBuilder("\u001b[48;5;237m" + piece.getToken() + " \u001b[0m");
            this.mColor = Utils.WHITE;
        }
        else{
            // this.mContent = new StringBuilder("\u001b[48;5;244m" + piece.getToken() + " \u001b[0m");
            this.mColor = Utils.BLACK;
        }
        this.mIsEmpty = false;
    }

    public Case(int x, int y) {
        this.mX = x;
        this.mY = y;
        if ((x % 2 == 0 && y % 2 != 0) || (x % 2 != 0 && y % 2 == 0)) {
            // this.mContent = new StringBuilder("\u001b[48;5;237m  \u001b[0m");
            this.mColor = true;
        }
        else {
            // this.mContent = new StringBuilder("\u001b[48;5;244m  \u001b[0m");
            this.mColor = false;
        }    
    }


    public int getX() {
        return this.mX;
    }

    public void setX(int x) {
        this.mX = x;
    }

    public int getY() {
        return this.mY;
    }

    public void setY(int y) {
        this.mY = y;
    }

    public Piece getPiece() {
        return this.mPiece;
    }

    public void setPiece(Piece piece) {
        this.mPiece = piece;
    }

    public String getContent() {
        return this.mContent.toString();
    }

    // public void setContent(String content) {
    //      if (this.mColor)
    //          this.mContent = new StringBuilder("\u001b[48;5;244m" + content + " \u001b[0m");
    //      else
    //          this.mContent = new StringBuilder("\u001b[48;5;237m" + content + " \u001b[0m");
    // }

    public boolean isEmpty() {
        return this.mIsEmpty;
    }

    public void setmIsEmpty(boolean isEmpty) {
        this.mIsEmpty = isEmpty;
    }

    public boolean getColor() {
        return this.mColor;
    }
}
