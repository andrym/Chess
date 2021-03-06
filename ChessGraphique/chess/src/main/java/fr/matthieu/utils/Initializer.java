package fr.matthieu.utils;

import fr.matthieu.chess.board.Board;
import fr.matthieu.chess.board.Case;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Initializer {

    public static void initCases(Board board) {
        // Case[][] cases = new Case[8][8];
        for (int i = 0; i < 16; i++) {
            // generatePiece();
        }
        // generateKing(board);
        // generateQueen(board);
        // generateBishop(board);
        // generateKnight(board);
        // generateRook(board);
        // generatePawns(board);
        // generateEmptyCases(board);
    }

    public ImageView initPieces(Case curCase, int i, int j) {
        ImageView piece;
        if (curCase.getPiece().getSide()) {
            piece = new ImageView(curCase.getPiece().getToken());
            piece.setFitHeight(50);
            piece.setFitWidth(50);
        } else {
            piece = new ImageView(curCase.getPiece().getToken());
            piece.setFitHeight(50);
            piece.setFitWidth(50);
        }
        return piece;
    }

    public Pane initPane(Case curCase) {
        Pane pane = new Pane();
        if (curCase.getColor())
            pane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, new CornerRadii(0), Insets.EMPTY)));
        else
            pane.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));
        return pane;
    }
}
