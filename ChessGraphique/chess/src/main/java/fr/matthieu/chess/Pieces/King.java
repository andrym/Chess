package fr.matthieu.chess.pieces;

import fr.matthieu.chess.assets.Assets;

public class King extends Piece {
    private int[][] moves = { { -1, 0 }, { -1, -1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, 1 }, { 0, -1 }, { -1, -1 } };

    public King(int x, int y, Boolean side) {
        super.x = x;
        super.y = y;
        super.side = side;
        super.moves = this.moves;
        super.type = "King";
        if (super.side)
            super.token = Assets.W_KING;
        else
            super.token = Assets.B_KING;
    }
}
