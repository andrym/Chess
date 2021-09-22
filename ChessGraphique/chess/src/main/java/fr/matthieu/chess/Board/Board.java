package fr.matthieu.chess.board;

import fr.matthieu.chess.pieces.Bishop;
import fr.matthieu.chess.pieces.King;
import fr.matthieu.chess.pieces.Knight;
import fr.matthieu.chess.pieces.Pawn;
import fr.matthieu.chess.pieces.Piece;
import fr.matthieu.chess.pieces.Queen;
import fr.matthieu.chess.pieces.Rook;
import fr.matthieu.chess.pieces.TempPawn;

public class Board {
    public Case[][] mCases = new Case[8][8];
    public String[][] mtakenWhite = {
            { "\u001b[48;5;237m\u001b[38;5;255m \u265B ", "\u001b[48;5;237m\u001b[38;5;255m 0 " },
            { "\u001b[38;5;255m \u265C ", " 0 " }, { "\u001b[38;5;255m \u265D ", " 0 " },
            { "\u001b[38;5;255m \u265E ", " 0 " }, { "\u001b[38;5;255m \u265F  \u001b[0m", " 0  \u001b[0m" } };
    public String[][] mtakenBlack = { { "\u001b[48;5;244m\u001b[38;5;0m 0 ", "\u001b[48;5;244m\u001b[38;5;0m \u265B " },
            { " 0 ", "\u001b[38;5;0m \u265C " }, { " 0 ", "\u001b[38;5;0m \u265D " },
            { " 0 ", "\u001b[38;5;0m \u265E " }, { " 0  \u001b[0m", "\u001b[38;5;0m \u265F  \u001b[0m" } };

    public Board() {
        generateKing();
        generateQueen();
        generateBishop();
        generateKnight();
        generateRook();
        generatePawns();
        generateEmptyCases();
    }

    public void generateKing() {
        this.mCases[0][4] = new Case(0, 4, new King(0, 4, false));
        this.mCases[7][3] = new Case(7, 3, new King(7, 3, true));
    }

    public void generateQueen() {
        this.mCases[0][3] = new Case(0, 3, new Queen(0, 3, false));
        this.mCases[7][4] = new Case(7, 4, new Queen(7, 4, true));
    }

    public void generateBishop() {
        this.mCases[0][2] = new Case(0, 2, new Bishop(0, 2, false));
        this.mCases[0][5] = new Case(0, 5, new Bishop(0, 5, false));
        this.mCases[7][2] = new Case(7, 2, new Bishop(7, 2, true));
        this.mCases[7][5] = new Case(7, 5, new Bishop(7, 5, true));
    }

    public void generateKnight() {
        this.mCases[0][1] = new Case(0, 1, new Knight(0, 1, false));
        this.mCases[0][6] = new Case(0, 6, new Knight(0, 6, false));
        this.mCases[7][1] = new Case(7, 1, new Knight(7, 1, true));
        this.mCases[7][6] = new Case(7, 6, new Knight(7, 6, true));
    }

    public void generateRook() {
        this.mCases[0][0] = new Case(0, 0, new Rook(0, 0, false));
        this.mCases[0][7] = new Case(0, 7, new Rook(0, 7, false));
        this.mCases[7][0] = new Case(7, 0, new Rook(7, 0, true));
        this.mCases[7][7] = new Case(7, 7, new Rook(7, 7, true));
    }

    public void generatePawns() {
        for (int j = 0; j < 8; j++) {
            this.mCases[1][j] = new Case(1, j, new Pawn(1, j, false));
            this.mCases[6][j] = new Case(6, j, new Pawn(6, j, true));
        }
    }

    public void generateEmptyCases() {
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                this.mCases[i][j] = new Case(i, j);
            }
        }
    }

    public Case[][] getCases() {
        return this.mCases;
    }

    public void printTaken(int count) {
        if (count == 1 || count == 2)
            for (String[] piece : this.mtakenBlack) {
                if (count == 2)
                    System.out.print(piece[1]);
                else
                    System.out.print(piece[0]);
            }
        if (count == 7 || count == 8)
            for (String[] piece : this.mtakenWhite) {
                if (count == 8)
                    System.out.print(piece[1]);
                else
                    System.out.print(piece[0]);
            }
    }

    public void handlePass(int ox, int oy, Piece piece) {
        int dy = oy + piece.getMoves()[0][0];
        TempPawn pieceCp = new TempPawn(ox, dy, piece);
        this.mCases[dy][ox].setMPiece(pieceCp);
    }

    public boolean checkPassing(int dx, int dy, Piece piece, boolean moving) {
        Piece sidePiece = null;

        if (!moving) {
            sidePiece = this.mCases[piece.getX()][dx].getMPiece();
            if (sidePiece.getPassed() && sidePiece.getSide() != piece.getSide()) {
                movePiece(piece.getY(), piece.getX(), dx, piece.getX());
                return true;
            }
            return false;

        } else {
            System.out.println("p");
            if (dx >= 0 && dx < 7) {
                System.out.println("pa");
                if (!this.mCases[dy][dx + 1].isEmpty()) {
                    sidePiece = this.mCases[dy][dx + 1].getMPiece();
                    System.out.println("pass: " + this.mCases[dy][dx + 1].getMPiece().getType());
                }
            } else if (dx > 0 && dx <= 7) {
                System.out.println("pas");
                if (!this.mCases[dy][dx - 1].isEmpty()) {
                    sidePiece = this.mCases[dy][dx - 1].getMPiece();
                    System.out.println("pass: " + this.mCases[dy][dx - 1].getMPiece().getType());

                }
            }

            if (sidePiece == null)
                return true;
            System.out.println("passi: " + sidePiece.getSide());

            if (sidePiece.getSide() != piece.getSide()) {
                System.out.println("passing");
                piece.setPassed(true);
                return true;
            }
        }
        return true;
    }

    public boolean pawnHandler(int dx, int dy, Piece piece) {
        if (piece.getDir() == 1 || piece.getDir() == 2) {
            if (!this.mCases[dy][dx].isEmpty()) {
                if (this.mCases[dy][dx].mPiece.getSide() != piece.getSide())
                    return true;
            } else
                return checkPassing(dx, dy, piece, false);
        } else if (piece.getDir() == 3) {
            if (this.mCases[dy][dx].isEmpty())
                if (this.mCases[dy][dx].isEmpty())
                    return checkPassing(dx, dy, piece, true);
        }
        return true;
    }

    public boolean isDestEnnemy(int dx, int dy, Piece piece) {
        if (piece.getType() == "Pawn") {
            return pawnHandler(dx, dy, piece);
        }
        if (!this.mCases[dy][dx].isEmpty()) {
            if (this.mCases[dy][dx].mPiece.getSide() != piece.getSide()) {
                return true;
            } else
                return false;
        }
        return true;
    }

    public boolean checkMove(int ox, int oy, int dx, int dy, Piece piece) {
        int x = ox;
        int y = oy;

        if (this.mCases[oy][ox].mPiece.isMoveOk(dy, dx)) {
            if (piece.getType() != "Knight") {
                while (x != dx || y != dy) {
                    if (x + piece.getMoves()[piece.getDir()][1] >= 0 && x + piece.getMoves()[piece.getDir()][1] < 8)
                        x += piece.getMoves()[piece.getDir()][1];
                    if (y + piece.getMoves()[piece.getDir()][0] >= 0 && y + piece.getMoves()[piece.getDir()][0] < 8)
                        y += piece.getMoves()[piece.getDir()][0];
                    if (x < 0 && x > 7 && y < 0 && y > 8)
                        return false;
                    if (!this.mCases[y][x].isEmpty() && (x != dx || y != dy)) {
                        return false;
                    }
                }
            }
            return isDestEnnemy(dx, dy, piece);
        }
        return false;
    }

    public void removePiece(int x, int y) {
        this.mCases[y][x].mPiece = null;
        this.mCases[y][x].setmIsEmpty(true);
    }

    public boolean movePiece(int ox, int oy, int dx, int dy) {
        if (this.mCases[oy][ox].mPiece.getType() == "Pawn" && !this.mCases[dy][dx].isEmpty())
            if (this.mCases[dy][dx].mPiece.getType() == "Passing")
                System.out.println("passing");
        // handlePass(ox, oy, this.mCases[oy][ox].mPiece);
        this.mCases[dy][dx].mPiece = this.mCases[oy][ox].mPiece;
        this.mCases[dy][dx].mPiece.setX(dy);
        this.mCases[dy][dx].mPiece.setY(dx);
        this.mCases[dy][dx].mPiece.setHasMoved(true);
        this.mCases[dy][dx].setmIsEmpty(false);
        removePiece(ox, oy);
        return true;
    }
}
