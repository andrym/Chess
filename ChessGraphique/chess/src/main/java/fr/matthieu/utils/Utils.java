package fr.matthieu.utils;

import java.util.HashMap;

public class Utils {
    public final static int W_ROW = 0;
    public final static int W_PROW = 1;
    public final static int B_ROW = 7;
    public final static int B_PROW = 6;
    public final static int R_RK = 0;
    public final static int L_RK = 7;
    public final static int R_KT = 1;
    public final static int L_KT = 6;
    public final static int R_BP = 2;
    public final static int L_BP = 5;
    public final static int KG = 4;
    public final static int QN = 3;

    public final static boolean WHITE = true;
    public final static boolean BLACK = false;

    public static String getPieceType(int x, int y) {
        String output = "";
        // System.out.println(x + " " + y);
        for (InitEnum value : InitEnum.values()) {
            if (value.x == x && value.y == y) {
                // System.out.println("inIF");
                return value.className;
            }
            // System.out.println("PASINIF" + value.className);
            // System.out.printf("(%d, %d)\n", value.x, value.y);
        }
        return output;
    }
}
