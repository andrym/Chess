package fr.matthieu.chess;

import fr.matthieu.chess.Game.Game;

// import java.util.Scanner;

// import fr.matthieu.chess.Board.Board;
public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.mainLoop();
        // Scanner sc = new Scanner(System.in);
        // Board   board = new Board();        
        // board.printBoard();
        // System.out.println("Jouez un piece: ");

    }

    // public static void main(String[] args) {
    //     King kb = new King(5, 1, -1);
    //     Case c1 = new Case(5, 1, kb);
    //     System.out.println("Sur la case en " + c1.getMX() + " " + c1.getMY() + " il y a : " + c1.getMPiece().getToken() + " de side: " + c1.getMPiece().getSide());
    //     for (int i = 0; i < 8; i++) {
    //         for (int j = 0; j < 8; j++) {
    //             if (i % 2 == 0) {
    //                 if (j % 2 == 0)
    //                     System.out.print("\u001b[48;5;244m  \u001b[0m");
    //                 else
    //                     System.out.print("\u001b[48;5;236m\u001b[38;5;255m\u2658 \u001b[0m");
    //             }
    //             else {
    //                 if (j % 2 != 0)
    //                     System.out.print("\u001b[48;5;244m\u001b[38;5;255m\u2658 \u001b[0m");
    //                 else
    //                     System.out.print("\u001b[48;5;236m\u001b[38;5;0m\u265E \u001b[0m");
    //             }
    //         }
    //         System.out.print("\n");
    //     }
    //     System.out.println("\u001b[48;5;94m \u001b[38;5;0m \u265E \u001b[38;5;255m \u2658  \u001b[0m");
    //     System.out.println("\u001b[7m\u265E \u001b[0m\u265E");
    //     System.out.println("\u001b[7m\u2658 \u001b[0m\u2658");        
    // }
}
