package fr.matthieu.chess.pieces;

import fr.matthieu.chess.assets.Assets;

public class Queen extends Piece {
    private int[][] moves = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

    public Queen(int x, int y, Boolean side) {
        super.mX = x;
        super.mY = y;
        super.mSide = side;
        super.mMoves = this.moves;
        super.mType = "Queen";
        if (side)
            super.mToken = Assets.W_QUEEN;
        else
            super.mToken = Assets.B_QUEEN;
    }

    @Override
    public boolean isMoveOk(int x, int y) {
        int moveX;
        int moveY;
        int dist = super.calcDist(super.mX - x, super.mY - y);

        super.mDir = 0;
        if ((x < 0 && x > 7) && (y < 0 || y > 7))
            return false;
        for (int[] move : mMoves) {
            moveX = super.mX;
            moveY = super.mY;
            for (int i = 0; i <= dist; i++) {
                moveX += move[0];
                moveY += move[1];
                if (moveX == x && moveY == y)
                    return true;
                if ((moveX < 0 || moveX > 7) || (moveY < 0 || moveY > 7))
                    i = 8;
            }
            super.mDir++;
        }
        super.mDir = -1;
        return false;
    }
}
