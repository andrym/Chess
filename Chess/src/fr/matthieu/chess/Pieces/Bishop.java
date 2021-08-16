package fr.matthieu.chess.Pieces;

public class Bishop extends Piece{

    public Bishop(int x, int y, int side) {
        int[][] moves = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
        this.mX = x;
        this.mY = y;
        this.mSide = side;
        this.mMoves = moves;
        this.mType = "Bishop";
        if (side == 1)
            this.mToken = "\u001b[38;5;255m\u265D";
        else
            this.mToken = "\u001b[38;5;0m\u265D";
    }

    @Override
    public boolean isMoveOk(int x, int y) {
        int moveX;
        int moveY;
        int dist = this.calcDist(this.mX - x, this.mY - y);

        if ((x < 0 && x > 7) && (y < 0 || y > 7))
            return false;
        this.mDir = 0;
        for (int[] move : mMoves) {
            moveX = this.mX;
            moveY = this.mY;
            for (int i = 0; i <= dist; i++) {
                moveX += move[0];
                moveY += move[1];
                if (moveX == x && moveY == y)
                    return true;
                if ((moveX < 0 || moveX > 7) || (moveY < 0 || moveY > 7)) 
                    i = 8;
            }
            this.mDir++;
        }
        this.mDir = -1;
        return false;
    }
}
