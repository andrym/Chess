package fr.matthieu.chess.Pieces;

import fr.matthieu.chess.assets.Assets;

public class Bishop extends Piece{
    private int[][] moves = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};

    public Bishop(int x, int y, Boolean side) {
        super.mX = x;
        super.mY = y;
        super.mSide = side;
        super.mMoves = this.moves;
        super.mType = "Bishop";
        if (side)
            super.mToken = Assets.W_BISHOP;
        else
            super.mToken = Assets.B_BISHOP;

    }

    @Override
    public boolean isMoveOk(int x, int y) {
        int moveX;
        int moveY;
        int dist = super.calcDist(super.mX - x, super.mY - y);

        if ((x < 0 && x > 7) && (y < 0 || y > 7))
            return false;
        super.mDir = 0;
        for (int[] move : super.mMoves) {
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
