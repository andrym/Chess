package fr.matthieu.chess.pieces;

import javafx.scene.image.Image;

public abstract class Piece {
    protected int mX;
    protected int mY;
    protected int mDir = -1;
    protected int[][] mMoves;
    protected String mType;
    protected Image mToken;
    protected boolean mHasMoved = false;
    protected boolean mPassed = false;
    protected boolean mPassing = false;
    protected boolean mSide;

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

    public Image getToken() {
        return this.mToken;
    }

    public boolean getSide() {
        return this.mSide;
    }

    public boolean getHasMoved() {
        return this.mHasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.mHasMoved = hasMoved;
    }

    public boolean isDestAllie(int x, int y) {
        return false;
    }

    public boolean isDestEnnemie(int x, int y) {
        return false;
    }

    public int[][] getMoves() {
        return this.mMoves;
    }

    public String getType() {
        return this.mType;
    }

    public int getDir() {
        return this.mDir;
    }

    public boolean getPassed() {
        return this.mPassed;
    }

    public void setPassed(boolean passed) {
        this.mPassed = passed;
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
        this.mDir = 0;
        for (int[] move : mMoves) {
            moveX = this.mX + move[1];
            moveY = this.mY + move[0];
            if ((x == moveX && y == moveY))
                return true;
            this.mDir++;
        }
        this.mDir = -1;
        return false;
    }

    public void printInfo() {
        System.out.println(this.mToken);
    }
}
