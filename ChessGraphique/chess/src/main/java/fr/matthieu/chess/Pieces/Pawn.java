package fr.matthieu.chess.pieces;

import fr.matthieu.chess.assets.Assets;

public class Pawn extends Piece {
    private int[][] movesUp = { { -1, 0 }, { -1, -1 }, { -1, 1 }, { -2, 0 } };
    private int[][] movesDown = { { 1, 0 }, { 1, 1 }, { 1, -1 }, { 2, 0 } };

    public Pawn(int x, int y, Boolean side) {

        super.x = x;
        super.y = y;
        super.side = side;
        if (side)
            super.moves = this.movesUp;
        else
            super.moves = this.movesDown;
        super.type = "Pawn";
        if (side)
            super.token = Assets.W_PAWN;
        else
            super.token = Assets.B_PAWN;
    }

    @Override
    public boolean isMoveOk(int x, int y) {
        int moveX;
        int moveY;

        if ((x < 0 && x > 7) && (y < 0 || y > 7))
            return false;
        super.dir = 0;
        for (int[] move : super.moves) {
            moveX = super.x + move[0];
            moveY = super.y + move[1];
            if ((x == moveX && y == moveY)) {
                if (super.dir == 3 && super.hasMoved == true)
                    return false;
                return true;
            }
            super.dir++;
        }
        super.dir = -1;
        return false;
    }
}
