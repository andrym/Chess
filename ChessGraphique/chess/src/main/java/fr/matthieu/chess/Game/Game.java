package fr.matthieu.chess.game;

import java.util.Scanner;

import fr.matthieu.chess.board.Board;

public class Game {
    protected int[] mCoordsPiece = { -1, -1 };
    protected int[] mCoordsMove = { -1, -1 };
    protected Board mBoard = new Board();
    protected String mInputPiece;
    protected String mInputMove;
    protected Scanner mScan = new Scanner(System.in);

    public Game() {
    }

    public int[] parseCoord(String input) {
        int[] tmp = { 0, 0 };

        tmp[0] = input.charAt(0) - 97;
        tmp[1] = 7 - (input.charAt(1) - 49);
        return tmp;
    }

    public void resetCoord() {
        this.mCoordsPiece[0] = -1;
        this.mCoordsPiece[1] = -1;
        this.mCoordsMove[0] = -1;
        this.mCoordsMove[1] = -1;
    }

    public void mainLoop() {
        for (int i = 0; i < 10; i++) {
            this.mBoard.printBoard();
            resetCoord();
            while ((this.mCoordsPiece[0] < 0 || this.mCoordsPiece[0] > 7)
                    && (this.mCoordsPiece[1] < 0 || this.mCoordsPiece[1] > 7)) {
                System.out.println("Choisissez une piece: ");
                this.mInputPiece = this.mScan.nextLine();
                this.mCoordsPiece = parseCoord(this.mInputPiece);
                if ((this.mCoordsPiece[0] < 0 || this.mCoordsPiece[0] > 7)
                        && (this.mCoordsPiece[1] < 0 || this.mCoordsPiece[1] > 7))
                    System.out.println("Coordonées de Case invalide (de a à b et de 1 à 8)");
            }
            while (this.mBoard.getCases()[this.mCoordsPiece[1]][this.mCoordsPiece[0]].getmIsEmpty() == true) {
                System.out.println("Cette case est vide changez de case: ");
                this.mInputPiece = this.mScan.nextLine();
                this.mCoordsPiece = parseCoord(this.mInputPiece);
            }
            while ((this.mCoordsMove[0] < 0 || this.mCoordsMove[0] > 7)
                    && (this.mCoordsMove[1] < 0 || this.mCoordsMove[1] > 7)) {
                System.out.println("Choisissez un move: ");
                this.mInputMove = this.mScan.nextLine();
                this.mCoordsMove = parseCoord(this.mInputMove);
                if ((this.mCoordsMove[0] < 0 || this.mCoordsMove[0] > 7)
                        && (this.mCoordsMove[1] < 0 || this.mCoordsMove[1] > 7))
                    System.out.println("Coordonées de Case invalide (de a à b et de 1 à 8)");
            }
            if (this.mBoard.movePiece(this.mCoordsPiece[0], this.mCoordsPiece[1], this.mCoordsMove[0],
                    this.mCoordsMove[1]) == true)
                System.out.println("Piéce bougée");
            else
                System.out.println("Mouvement impossible");
        }
    }
}
