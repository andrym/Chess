package fr.matthieu;
/*
Put header here


 */

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

import fr.matthieu.chess.Board.Board;
import fr.matthieu.chess.Board.Case;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class FXMLController implements Initializable {

    private ImageView[][] pieces = new ImageView[2][16];
    private int[] mCoordsPiece = { -1, -1 };
    private int[] mCoordsMove = { -1, -1 };
    private Board mBoard = new Board();

    @FXML
    private GridPane gdMainGrid;

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
        // for (int i = 0; i < 10; i++) {
        // this.mBoard.printBoard();
        // resetCoord();
        // while ((this.mCoordsPiece[0] < 0 || this.mCoordsPiece[0] > 7)
        // && (this.mCoordsPiece[1] < 0 || this.mCoordsPiece[1] > 7)) {
        // System.out.println("Choisissez une piece: ");
        // this.mInputPiece = this.mScan.nextLine();
        // this.mCoordsPiece = parseCoord(this.mInputPiece);
        // if ((this.mCoordsPiece[0] < 0 || this.mCoordsPiece[0] > 7)
        // && (this.mCoordsPiece[1] < 0 || this.mCoordsPiece[1] > 7))
        // System.out.println("Coordonées de Case invalide (de a à b et de 1 à 8)");
        // }
        // while
        // (this.mBoard.getCases()[this.mCoordsPiece[1]][this.mCoordsPiece[0]].getmIsEmpty()
        // == true) {
        // System.out.println("Cette case est vide changez de case: ");
        // this.mInputPiece = this.mScan.nextLine();
        // this.mCoordsPiece = parseCoord(this.mInputPiece);
        // }
        // while ((this.mCoordsMove[0] < 0 || this.mCoordsMove[0] > 7)
        // && (this.mCoordsMove[1] < 0 || this.mCoordsMove[1] > 7)) {
        // System.out.println("Choisissez un move: ");
        // this.mInputMove = this.mScan.nextLine();
        // this.mCoordsMove = parseCoord(this.mInputMove);
        // if ((this.mCoordsMove[0] < 0 || this.mCoordsMove[0] > 7)
        // && (this.mCoordsMove[1] < 0 || this.mCoordsMove[1] > 7))
        // System.out.println("Coordonées de Case invalide (de a à b et de 1 à 8)");
        // }
        // if (this.mBoard.movePiece(this.mCoordsPiece[0], this.mCoordsPiece[1],
        // this.mCoordsMove[0],
        // this.mCoordsMove[1]) == true)
        // System.out.println("Piéce bougée");
        // else
        // System.out.println("Mouvement impossible");
        // }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Pane panes[][] = new Pane[8][8];
        int x = 0;
        int y = 0;
        Case[][] cases = mBoard.getCases();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                panes[i][j] = new Pane();
                if (cases[i][j].getColor())
                    panes[i][j].setBackground(
                            new Background(new BackgroundFill(Color.DARKGRAY, new CornerRadii(0), Insets.EMPTY)));
                else
                    panes[i][j].setBackground(
                            new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));
                gdMainGrid.add(panes[i][j], j, i);
                if (!cases[i][j].getmIsEmpty()) {
                    System.out.printf("i: %d  j: %d\n", i, j);
                    if (cases[i][j].getMPiece().getSide()) {
                        System.out.println("MDR: " + cases[i][j].getMPiece().getToken());
                        pieces[0][x] = new ImageView(cases[i][j].getMPiece().getToken());
                        pieces[0][x].setFitHeight(50);
                        pieces[0][x].setFitWidth(50);
                        gdMainGrid.add(pieces[0][x++], j, i);
                    } else {
                        System.out.println("MDR2: " + cases[i][j].getMPiece().getType());
                        pieces[1][y] = new ImageView(cases[i][j].getMPiece().getToken());
                        pieces[1][y].setFitHeight(50);
                        pieces[1][y].setFitWidth(50);
                        gdMainGrid.add(pieces[1][y++], j, i);
                    }
                }
            }
        }

    }
}
