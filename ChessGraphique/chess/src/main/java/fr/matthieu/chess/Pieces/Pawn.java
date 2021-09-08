package fr.matthieu.chess.Pieces;

public class Pawn extends Piece {

    public Pawn(int x, int y, Boolean side) {
        int[][] movesUp = { { -1, 0 }, { -1, -1 }, { -1, 1 }, { -2, 0 } };
        int[][] movesDown = { { 1, 0 }, { 1, 1 }, { 1, -1 }, { 2, 0 } };

        this.mX = x;
        this.mY = y;
        this.mSide = side;
        if (side)
            this.mMoves = movesUp;
        else
            this.mMoves = movesDown;
        this.mType = "Pawn";
        if (side)
            this.mToken = getClass().getResource("assets/chess_piece_white_pawn_T.png");
        else
            this.mToken = getClass().getResource("assets/chess_piece_black_pawn_T.png");
    }

    @Override
    public boolean isMoveOk(int x, int y) {
        int moveX;
        int moveY;

        if ((x < 0 && x > 7) && (y < 0 || y > 7))
            return false;
        this.mDir = 0;
        for (int[] move : mMoves) {
            moveX = this.mX + move[0];
            moveY = this.mY + move[1];
            if ((x == moveX && y == moveY)) {
                if (this.mDir == 3 && this.mHasMoved == true)
                    return false;
                // if ()
                return true;
            }
            this.mDir++;
        }
        this.mDir = -1;
        return false;
    }
}
