package fr.matthieu.chess.Board;


import fr.matthieu.chess.Pieces.Piece;

public class Case {
    protected int           mX;
    protected int           mY;
    protected int           mColor;
    protected Piece         mPiece;
    protected boolean       mIsEmpty = true;
    protected StringBuilder mContent;

    public Case(int x, int y, Piece piece) {
        this.mX = x;
        this.mY = y;
        this.mPiece = piece;
        if ((x % 2 == 0 && y % 2 != 0) || (x % 2 != 0 && y % 2 == 0)) {
            this.mContent = new StringBuilder("\u001b[48;5;237m" + piece.getToken() + " \u001b[0m");
            this.mColor = 0;
        }
        else{
            this.mContent = new StringBuilder("\u001b[48;5;244m" + piece.getToken() + " \u001b[0m");
            this.mColor = 1;
        }
        this.mIsEmpty = false;
    }

    public Case(int x, int y) {
        this.mX = x;
        this.mY = y;
        if ((x % 2 == 0 && y % 2 != 0) || (x % 2 != 0 && y % 2 == 0)) {
            this.mContent = new StringBuilder("\u001b[48;5;237m  \u001b[0m");
            this.mColor = 0;
        }
        else {
            this.mContent = new StringBuilder("\u001b[48;5;244m  \u001b[0m");
            this.mColor = 1;
        }    
    }


    public int getMX() {
        return this.mX;
    }

    public void setMX(int x) {
        this.mX = x;
    }

    public int getMY() {
        return this.mY;
    }

    public void setMY(int y) {
        this.mY = y;
    }

    public Piece getMPiece() {
        return this.mPiece;
    }

    public void setMPiece(Piece piece) {
        this.mPiece = piece;
    }

    public String getMContent() {
        return this.mContent.toString();
    }

    public void setContent(String content) {
        if (this.mColor == 1)
            this.mContent = new StringBuilder("\u001b[48;5;244m" + content + " \u001b[0m");
        else
            this.mContent = new StringBuilder("\u001b[48;5;237m" + content + " \u001b[0m");
    }

    public boolean getmIsEmpty() {
        return this.mIsEmpty;
    }

    public void setmIsEmpty(boolean isEmpty) {
        this.mIsEmpty = isEmpty;
    }
}
