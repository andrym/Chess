package fr.matthieu.chess.pieces;

import fr.matthieu.chess.assets.Assets;

public class Rook extends Piece {
    // protected int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public Rook(int x, int y, Boolean side) {
        super.x = x;
        super.y = y;
        super.side = side;
        super.moves = this.moves;
        super.type = "Rook";
        if (side)
            super.token = Assets.W_ROOK;
        else
            super.token = Assets.B_ROOK;
    }

    @Override
    public boolean isMoveOk(int x, int y) {
        int moveX;
        int moveY;
        int dist = super.calcDist(super.x - x, super.y - y);

        super.dir = -1;
        if (dist == -1)
            return false;
        if ((x < 0 && x > 7) && (y < 0 || y > 7))
            return false;
        for (int[] move : moves) {
            moveX = super.x;
            moveY = super.y;
            super.dir++;
            for (int i = 0; i <= dist; i++) {
                moveX += move[0];
                moveY += move[1];
                if (moveX == x && moveY == y)
                    return true;
                if ((moveX < 0 || moveX > 7) || (moveY < 0 || moveY > 7))
                    i = 8;
            }
        }
        super.dir = -1;
        return false;
    }
}
