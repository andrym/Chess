package fr.matthieu.chess.Pieces;

public class King extends Piece{

    public King(int x, int y, int side) {
        int[][] moves = {{-1, 0}, {-1, -1}, {0, 1}, {1, 1}, {1, 0}, {1, 1}, {0, -1}, {-1, -1}};
        this.mX = x;
        this.mY = y;
        this.mSide = side;
        this.mMoves = moves;
        this.mType = "King";
        if (this.mSide == 1)
            this.mToken = "\u001b[38;5;255m\u265A";
        else
            this.mToken = "\u001b[38;5;0m\u265A";
    }

    @Override
    public boolean isMoveOk(int x, int y) {
        int moveX;
        int moveY;

        this.mDir = 0;
        if ((x < 0 && x > 7) && (y < 0 || y > 7))
            return false;
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
}
