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

    B_QUEEN(Utils.B_ROW, Utils.QN, Utils.BLACK, Queen.class),
    B_KING(Utils.B_ROW, Utils.KG, Utils.BLACK, King.class),
    B_R_KNIGHT(Utils.B_ROW, Utils.R_KT, Utils.BLACK, Knight.class),
    B_L_KNIGHT(Utils.B_ROW, Utils.L_KT, Utils.BLACK, Knight.class),
    B_R_BISHOP(Utils.B_ROW, Utils.R_BP, Utils.BLACK, Bishop.class),
    B_L_BISHOP(Utils.B_ROW, Utils.L_BP, Utils.BLACK, Bishop.class),
    B_R_ROOK(Utils.B_ROW, Utils.R_RK, Utils.BLACK, Rook.class),
    B_L_ROOK(Utils.B_ROW, Utils.L_RK, Utils.BLACK, Rook.class);

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

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean getColor() {
        return this.color;
    }

    public Class<?> getPClass() {
        return this.cls;
    }
}
