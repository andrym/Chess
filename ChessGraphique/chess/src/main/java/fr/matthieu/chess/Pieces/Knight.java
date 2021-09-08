package fr.matthieu.chess.Pieces;

public class Knight extends Piece {

    public Knight(int x, int y, Boolean side) {
        int[][] moves = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };
        this.mX = x;
        this.mY = y;
        this.mSide = side;
        this.mMoves = moves;
        this.mType = "Knight";
        if (side)
            this.mToken = getClass().getResource("assets/chess_piece_white_knight_T.png");
        else
            this.mToken = getClass().getResource("assets/chess_piece_black_knight_T.png");
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
