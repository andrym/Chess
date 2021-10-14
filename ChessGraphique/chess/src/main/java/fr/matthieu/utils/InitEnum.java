package fr.matthieu.utils;

import fr.matthieu.chess.pieces.Bishop;
import fr.matthieu.chess.pieces.King;
import fr.matthieu.chess.pieces.Knight;
import fr.matthieu.chess.pieces.Queen;
import fr.matthieu.chess.pieces.Rook;

public enum InitEnum {

    W_QUEEN(Utils.W_ROW, Utils.QN, Utils.WHITE, Queen.class),
    W_KING(Utils.W_ROW, Utils.KG, Utils.WHITE, King.class),
    W_R_KNIGHT(Utils.W_ROW, Utils.R_KT, Utils.WHITE, Knight.class),
    W_L_KNIGHT(Utils.W_ROW, Utils.L_KT, Utils.WHITE, Knight.class),
    W_R_BISHOP(Utils.W_ROW, Utils.R_BP, Utils.WHITE, Bishop.class),
    W_L_BISHOP(Utils.W_ROW, Utils.L_BP, Utils.WHITE, Bishop.class),
    W_R_ROOK(Utils.W_ROW, Utils.R_RK, Utils.WHITE, Rook.class),
    W_L_ROOK(Utils.W_ROW, Utils.L_RK, Utils.WHITE, Rook.class),

    B_QUEEN(Utils.B_ROW, Utils.QN, Utils.WHITE, Queen.class),
    B_KING(Utils.B_ROW, Utils.KG, Utils.WHITE, King.class),
    B_R_KNIGHT(Utils.B_ROW, Utils.R_KT, Utils.WHITE, Knight.class),
    B_L_KNIGHT(Utils.B_ROW, Utils.L_KT, Utils.WHITE, Knight.class),
    B_R_BISHOP(Utils.B_ROW, Utils.R_BP, Utils.WHITE, Bishop.class),
    B_L_BISHOP(Utils.B_ROW, Utils.L_BP, Utils.WHITE, Bishop.class),
    B_R_ROOK(Utils.B_ROW, Utils.R_RK, Utils.WHITE, Rook.class),
    B_L_ROOK(Utils.B_ROW, Utils.L_RK, Utils.WHITE, Rook.class);


    int x;
    int y;
    Boolean color;
    Class<?> cls;
    String className;

    InitEnum(int row, int col, boolean color, Class<?> cls) {
        this.x = col;
        this.y = row;
        this.color = color;
        this.cls = cls;
        this.className = cls.getName();
    }
    // public void generateKing() {        
    //     this.mCases[0][4] = new Case(0, 4, new King(0, 4, false));
    //     this.mCases[7][4] = new Case(7, 4, new King(7, 4, true));
    // }

    // public void generateQueen() {
    //     this.mCases[0][3] = new Case(0, 3, new Queen(0, 3, false));
    //     this.mCases[7][3] = new Case(7, 3, new Queen(7, 3, true));
    // }

    // public void generateBishop() {
    //     this.mCases[0][2] = new Case(0, 2, new Bishop(0, 2, false));
    //     this.mCases[0][5] = new Case(0, 5, new Bishop(0, 5, false));
    //     this.mCases[7][2] = new Case(7, 2, new Bishop(7, 2, true));
    //     this.mCases[7][5] = new Case(7, 5, new Bishop(7, 5, true));
    // }

    // public void generateKnight() {
    //     this.mCases[0][1] = new Case(0, 1, new Knight(0, 1, false));
    //     this.mCases[0][6] = new Case(0, 6, new Knight(0, 6, false));
    //     this.mCases[7][1] = new Case(7, 1, new Knight(7, 1, true));
    //     this.mCases[7][6] = new Case(7, 6, new Knight(7, 6, true));
    // }

    // public void generateRook() {
    //     this.mCases[0][0] = new Case(0, 0, new Rook(0, 0, false));
    //     this.mCases[0][7] = new Case(0, 7, new Rook(0, 7, false));
    //     this.mCases[7][0] = new Case(7, 0, new Rook(7, 0, true));
    //     this.mCases[7][7] = new Case(7, 7, new Rook(7, 7, true));
    // }

    // public void generatePawns() {
    //     for (int j = 0; j < 8; j++) {
    //         this.mCases[1][j] = new Case(1, j, new Pawn(1, j, false));
    //         this.mCases[6][j] = new Case(6, j, new Pawn(6, j, true));
    //     }
    // }
    
}
