package fr.matthieu.chess.pieces;

import javafx.scene.image.Image;

public abstract class Piece {
    protected int x;
    protected int y;
    protected int dir = -1;
    protected int[][] moves;
    protected String type;
    protected Image token;
    protected boolean hasMoved = false;
    protected boolean passed = false;
    protected boolean passing = false;
    protected boolean side;

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

    public Image getToken() {
        return this.token;
    }

    public boolean getSide() {
        return this.side;
    }

    public boolean getHasMoved() {
        return this.hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public boolean isDestAllie(int x, int y) {
        return false;
    }

    public boolean isDestEnnemie(int x, int y) {
        return false;
    }

    public int[][] getMoves() {
        return this.moves;
    }

    public String getType() {
        return this.type;
    }

    public int getDir() {
        return this.dir;
    }

    public boolean getPassed() {
        return this.passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public int calcDist(int x, int y) {
        if (x < 0)
            x *= -1;
        if (y < 0)
            y *= -1;
        if (x == y)
            return x;
        if (x == 0)
            return y;
        if (y == 0)
            return x;
        return -1;
    }

    public boolean isMoveOk(int x, int y) {
        int moveX;
        int moveY;

        if ((x < 0 && x > 7) && (y < 0 || y > 7))
            return false;
        this.dir = 0;
        for (int[] move : moves) {
            moveX = this.x + move[1];
            moveY = this.y + move[0];
            if ((x == moveX && y == moveY))
                return true;
            this.dir++;
        }
        this.dir = -1;
        return false;
    }

    public void printInfo() {
        System.out.println(this.token);
    }
}
