package fr.matthieu.chess.board;

import fr.matthieu.chess.pieces.Bishop;
import fr.matthieu.chess.pieces.King;
import fr.matthieu.chess.pieces.Knight;
import fr.matthieu.chess.pieces.Pawn;
import fr.matthieu.chess.pieces.Piece;
import fr.matthieu.chess.pieces.Queen;
import fr.matthieu.chess.pieces.Rook;
import fr.matthieu.chess.pieces.TempPawn;
import fr.matthieu.utils.Initializer;

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
        Initializer.initCases(this);

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
        this.mCases[7][4] = new Case(7, 4, new King(7, 4, true));
    }

    public void generateQueen() {
        this.mCases[0][3] = new Case(0, 3, new Queen(0, 3, false));
        this.mCases[7][3] = new Case(7, 3, new Queen(7, 3, true));
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

    // public void printTaken(int count) {
    //     if (count == 1 || count == 2)
    //         for (String[] piece : this.mtakenBlack) {
    //             if (count == 2)
    //                 System.out.print(piece[1]);
    //             else
    //                 System.out.print(piece[0]);
    //         }
    //     if (count == 7 || count == 8)
    //         for (String[] piece : this.mtakenWhite) {
    //             if (count == 8)
    //                 System.out.print(piece[1]);
    //             else
    //                 System.out.print(piece[0]);
    //         }
    // }

    public void handlePass(int ox, int oy, Piece piece) {
        int dy = oy + piece.getMoves()[0][0];
        System.out.println("PIECE dy:" + dy);
        TempPawn pieceCp = new TempPawn(ox, dy, piece);
        this.mCases[dy][ox].setPiece(pieceCp);
        this.mCases[dy][ox].setmIsEmpty(false);
        System.out.println("WAWOU");
    }

    public boolean checkPassing(int dx, int dy, Piece piece, boolean dropped) {
        Piece sidePiece = null;

        if (dx >= 0 && dx < 7) {
            System.out.println("OHOH");
            if (!this.mCases[dy][dx + 1].isEmpty()) {
                sidePiece = this.mCases[dy][dx + 1].getPiece();
            }
        }
        if (dx > 0 && dx <= 7) {
            System.out.println("Stinky");
            if (!this.mCases[dy][dx - 1].isEmpty()) {
                sidePiece = this.mCases[dy][dx - 1].getPiece();
            }
        }
        if (sidePiece == null)
            return false;
        if (sidePiece.getSide() != piece.getSide()) {
            if (dropped) {
                System.out.println(
                        "Handle Pass x: " + piece.getY() + " y: " + piece.getX() + " Type: " + piece.getType());
                handlePass(piece.getY(), piece.getX(), piece);
                piece.setPassed(true);
            } else
                System.out.println("PasDropped");

            return true;
        }
        return false;
    }

    public boolean pawnHandler(int dx, int dy, Piece piece) {
        if (piece.getDir() == 1 || piece.getDir() == 2) {
            if (!this.mCases[dy][dx].isEmpty()) {
                if (this.mCases[dy][dx].getPiece().getSide() != piece.getSide())
                    return true;
            } else
                return false;
        } else if (piece.getDir() == 3) {
            if (this.mCases[dy][dx].isEmpty())
                checkPassing(dx, dy, piece, false);
        }
        return true;
    }

    public boolean isDestEnnemy(int dx, int dy, Piece piece) {
        if (piece.getType() == "Pawn") {
            return pawnHandler(dx, dy, piece);
        }
        if (!this.mCases[dy][dx].isEmpty()) {
            if (this.mCases[dy][dx].getPiece().getSide() != piece.getSide()) {
                return true;
            } else
                return false;
        }
        return true;
    }

    public boolean checkMove(int ox, int oy, int dx, int dy, Piece piece) {
        int x = ox;
        int y = oy;

        if (this.mCases[oy][ox].getPiece() == null)
            System.out.println("CHEH");
        if (this.mCases[oy][ox].getPiece().isMoveOk(dy, dx)) {
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
        // System.out.println("WAWJESUISTROPBETE2");

        this.mCases[y][x].setPiece(null);
        this.mCases[y][x].setmIsEmpty(true);
    }

    public void printDebug(Piece oPiece, Piece dPiece, int ox, int oy, int dx, int dy) {
        System.out.printf("Piece: \norigin: %s | x: %d y: %d\ndest: %s | x: %d y: %d\n", oPiece, ox, oy, dPiece, dx,
                dy);

    }

    public boolean movePiece(Case oCase, Case dCase) {
        // System.out.printf("WAWJESUISTROPBETE1 oCase.getX(): %d oCase.getY(): %d
        // dCase.getX(): %d dCase.getY() %d\n", oCase.getX(), oCase.getY(),
        // dCase.getX(), dCase.getY());
        if (oCase.getPiece().getType() == "Pawn" && dCase.getPiece().getDir() == 3)
            checkPassing(oCase.getX(), oCase.getY(), oCase.getPiece(), true);
        printDebug(oCase.getPiece(), dCase.getPiece(), oCase.getX(), oCase.getY(), dCase.getX(), dCase.getY());
        // handlePass(oCase.getX(), oCase.getY(),
        // this.mCases[oCase.getY()][oCase.getX()].getPiece());
        dCase.setPiece(oCase.getPiece());
        dCase.getPiece().setX(dCase.getY());
        dCase.getPiece().setY(dCase.getX());
        dCase.getPiece().setHasMoved(true);
        dCase.setmIsEmpty(false);
        removePiece(oCase.getX(), oCase.getY());
        return true;
    }
}
