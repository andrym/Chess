package fr.matthieu.chess.pieces;

import fr.matthieu.chess.assets.Assets;

public class Knight extends Piece {
    private int[][] moves = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };

    public Knight(int x, int y, Boolean side) {
        super.x = x;
        super.y = y;
        super.side = side;
        super.moves = this.moves;
        super.type = "Knight";
        if (super.side)
            super.token = Assets.W_KNIGHT;
        else
            super.token = Assets.B_KNIGHT;
    }
}
