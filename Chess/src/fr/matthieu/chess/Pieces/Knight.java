package fr.matthieu.chess.Pieces;

public class Knight extends Piece{

    public Knight(int x, int y, int side) {
        int[][] moves = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
        this.mX = x;
        this.mY = y;
        this.mSide = side;
        this.mMoves = moves;
        this.mType = "Knight";
        if (side == 1)
            this.mToken = "\u001b[38;5;255m\u265E";
        else
            this.mToken = "\u001b[38;5;0m\u265E";
    }

    @Override
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
}
