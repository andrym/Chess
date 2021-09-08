package fr.matthieu.chess.Pieces;

public class Queen extends Piece {
    // protected int[][] mMoves = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1,
    // -1}, {0, -1}, {-1, -1}};

    public Queen(int x, int y, Boolean side) {
        int[][] moves = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
        this.mX = x;
        this.mY = y;
        this.mSide = side;
        this.mMoves = moves;
        this.mType = "Queen";
        if (side)
            this.mToken = getClass().getResource("assets/chess_piece_white_queen_T.png");
        else
            this.mToken = getClass().getResource("assets/chess_piece_black_queen_T.png");
    }

    @Override
    public boolean isMoveOk(int x, int y) {
        int moveX;
        int moveY;
        int dist = this.calcDist(this.mX - x, this.mY - y);

        this.mDir = 0;
        if ((x < 0 && x > 7) && (y < 0 || y > 7))
            return false;
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
