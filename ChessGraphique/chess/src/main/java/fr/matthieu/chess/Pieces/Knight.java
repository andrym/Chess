package fr.matthieu.chess.Pieces;

import fr.matthieu.chess.assets.Assets;

public class Knight extends Piece {
    private int[][] moves = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };

    public Knight(int x, int y, Boolean side) {
        super.mX = x;
        super.mY = y;
        super.mSide = side;
        super.mMoves = this.moves;
        super.mType = "Knight";
        if (side)
            super.mToken = Assets.W_KNIGHT;
        else
            super.mToken = Assets.B_KNIGHT;
    }
}
