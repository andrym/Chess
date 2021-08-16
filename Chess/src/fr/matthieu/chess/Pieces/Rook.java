package fr.matthieu.chess.Pieces;

public class Rook extends Piece {
    //protected int[][] mMoves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public Rook(int x, int y, int side) {
        int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        this.mX = x;
        this.mY = y;
        this.mSide = side;
        this.mMoves = moves;
        this.mType = "Rook";
        if (side == 1)
            this.mToken = "\u001b[38;5;255m\u265C";
        else
            this.mToken = "\u001b[38;5;0m\u265C";
    }

    @Override
    public boolean isMoveOk(int x, int y) {
        int moveX;
        int moveY;
        int dist = this.calcDist(this.mX - x, this.mY - y);

        this.mDir = -1;
        if (dist == -1)
            return false;
        if ((x < 0 && x > 7) && (y < 0 || y > 7))
            return false;
        for (int[] move : mMoves) {
            moveX = this.mX;
            moveY = this.mY;
            this.mDir++;
            for (int i = 0; i <= dist; i++) {
                moveX += move[0];
                moveY += move[1];
                if (moveX == x && moveY == y)
                    return true;
                if ((moveX < 0 || moveX > 7) || (moveY < 0 || moveY > 7)) 
                    i = 8;
            }
        }
        this.mDir = -1;
        return false;
    }
}
