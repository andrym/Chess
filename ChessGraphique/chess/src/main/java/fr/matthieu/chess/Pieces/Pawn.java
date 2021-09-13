package fr.matthieu.chess.Pieces;

import fr.matthieu.chess.assets.Assets;

public class Pawn extends Piece {
    private int[][] movesUp = { { -1, 0 }, { -1, -1 }, { -1, 1 }, { -2, 0 } };
    private int[][] movesDown = { { 1, 0 }, { 1, 1 }, { 1, -1 }, { 2, 0 } };

    public Pawn(int x, int y, Boolean side) {

        super.mX = x;
        super.mY = y;
        super.mSide = side;
        if (side)
            super.mMoves = this.movesUp;
        else
            super.mMoves = this.movesDown;
        super.mType = "Pawn";
        if (side)
            super.mToken = Assets.W_PAWN;
        else
            super.mToken = Assets.B_PAWN;
    }

    @Override
    public boolean isMoveOk(int x, int y) {
        int moveX;
        int moveY;

        if ((x < 0 && x > 7) && (y < 0 || y > 7))
            return false;
        super.mDir = 0;
        for (int[] move : super.mMoves) {
            moveX = super.mX + move[0];
            moveY = super.mY + move[1];
            if ((x == moveX && y == moveY)) {
                if (super.mDir == 3 && super.mHasMoved == true)
                    return false;
                return true;
            }
            super.mDir++;
        }
        super.mDir = -1;
        return false;
    }
}
