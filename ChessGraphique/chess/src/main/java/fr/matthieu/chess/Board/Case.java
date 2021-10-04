package fr.matthieu.chess.board;


import fr.matthieu.chess.pieces.Piece;
import fr.matthieu.utils.Utils;

public class Case {
    protected int           x;
    protected int           y;
    protected boolean       color;
    protected Piece         piece;
    protected boolean       isEmpty = true;
    protected StringBuilder content;

    public Case(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
        if ((x % 2 == 0 && y % 2 != 0) || (x % 2 != 0 && y % 2 == 0)) {
            // this.mContent = new StringBuilder("\u001b[48;5;237m" + piece.getToken() + " \u001b[0m");
            this.color = Utils.WHITE;
        }
        else{
            // this.mContent = new StringBuilder("\u001b[48;5;244m" + piece.getToken() + " \u001b[0m");
            this.color = Utils.BLACK;
        }
        this.isEmpty = false;
    }

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        if ((x % 2 == 0 && y % 2 != 0) || (x % 2 != 0 && y % 2 == 0)) {
            // this.mContent = new StringBuilder("\u001b[48;5;237m  \u001b[0m");
            this.color = true;
        }
        else {
            // this.mContent = new StringBuilder("\u001b[48;5;244m  \u001b[0m");
            this.color = false;
        }    
    }


    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public String getContent() {
        return this.content.toString();
    }

    // public void setContent(String content) {
    //      if (this.color)
    //          this.mContent = new StringBuilder("\u001b[48;5;244m" + content + " \u001b[0m");
    //      else
    //          this.mContent = new StringBuilder("\u001b[48;5;237m" + content + " \u001b[0m");
    // }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public void setisEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public boolean getColor() {
        return this.color;
    }
}
