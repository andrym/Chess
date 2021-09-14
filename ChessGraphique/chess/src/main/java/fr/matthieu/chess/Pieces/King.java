package fr.matthieu.chess.pieces;

import fr.matthieu.chess.assets.Assets;

public class King extends Piece {
    private int[][] moves = { { -1, 0 }, { -1, -1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, 1 }, { 0, -1 }, { -1, -1 } };

    public King(int x, int y, Boolean side) {
        super.mX = x;
        super.mY = y;
        super.mSide = side;
        super.mMoves = this.moves;
        super.mType = "King";
        if (super.mSide)
            super.mToken = Assets.W_KING;
        else
            super.mToken = Assets.B_KING;
    }
}
