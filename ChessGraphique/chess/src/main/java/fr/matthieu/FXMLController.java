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

import fr.matthieu.chess.board.Board;
import fr.matthieu.chess.board.Case;
import fr.matthieu.chess.pieces.Piece;
import fr.matthieu.utils.Initializer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Transform;

public class FXMLController implements Initializable {

    private ImageView[] pieces = new ImageView[32];
    private ImageView draggedPiece;
    private Board mBoard = new Board();
    private Pane panes[][] = new Pane[8][8];

    @FXML
    private GridPane gdMainGrid;

    public void setDraggedPiece(ImageView draggedPiece) {
        this.draggedPiece = draggedPiece;
    }

    public ImageView getDraggedPiece() {
        return this.draggedPiece;
    }

    public GridPane getGridPane() {
        return this.gdMainGrid;
    }

    public Board getBoard() {
        return this.mBoard;
    }

    public Pane[][] getPanes() {
        return this.panes;
    }

    public void removePiece(int dx, int dy) {

        for (int i = 0; i < 32 ; i++) {
            if (GridPane.getColumnIndex(this.pieces[i]) == dx && GridPane.getRowIndex(this.pieces[i]) == dy) {
                this.gdMainGrid.getChildren().remove(this.pieces[i]);
            }
        }
    }

    public void addDropHandling(Pane pane) {
        pane.setOnDragOver(e -> {
            Dragboard db = e.getDragboard();
            int dx = GridPane.getColumnIndex(pane);
            int dy = GridPane.getRowIndex(pane);
            int ox = GridPane.getColumnIndex(draggedPiece);
            int oy = GridPane.getRowIndex(draggedPiece);

            if (db.hasImage() && draggedPiece != null
                    && this.mBoard.checkMove(ox, oy, dx, dy, this.mBoard.mCases[oy][ox].getMPiece())) {
                e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            e.consume();
        });

        pane.setOnDragDropped(e -> {
            Dragboard db = e.getDragboard();
            int dx = GridPane.getColumnIndex(pane);
            int dy = GridPane.getRowIndex(pane);
            int ox = GridPane.getColumnIndex(draggedPiece);
            int oy = GridPane.getRowIndex(draggedPiece);
            Piece piece = this.mBoard.mCases[oy][ox].getMPiece();

            if (db.hasImage() && this.mBoard.checkMove(ox, oy, dx, dy, piece)) {
                if (this.mBoard.isDestEnnemy(dx, dy, piece)) {
                    removePiece(dx, dy);
                }
                removePiece(ox, oy);
                this.mBoard.movePiece(ox, oy, dx, dy);
                this.gdMainGrid.add(this.draggedPiece, dx, dy);
                e.setDropCompleted(true);
                this.draggedPiece = null;
                e.consume();
            }
        });

    }

    public void initDragablePiece(ImageView piece) {
        piece.setOnDragDetected((MouseEvent e) -> {
            Dragboard db = piece.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cc = new ClipboardContent();

            db.setDragView(piece.snapshot(null, null));
            cc.putImage(piece.getImage());
            db.setContent(cc);
            this.draggedPiece = piece;
            e.consume();
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int x = 0;
        Case[][] cases = mBoard.getCases();
        Initializer init = new Initializer();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.panes[i][j] = init.initPane(cases[i][j]);
                // if (cases[i][j].getColor())
                // this.panes[i][j].setBackground(
                // new Background(new BackgroundFill(Color.DARKGRAY, new CornerRadii(0),
                // Insets.EMPTY)));
                // else
                // this.panes[i][j].setBackground(
                // new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0),
                // Insets.EMPTY)));
                addDropHandling(this.panes[i][j]);
                this.gdMainGrid.add(this.panes[i][j], j, i);

                if (!cases[i][j].isEmpty()) {
                    this.pieces[x] = init.initPieces(cases[i][j], i, j);
                    initDragablePiece(this.pieces[x]);
                    this.gdMainGrid.add(this.pieces[x++], j, i);

                    // if (cases[i][j].getMPiece().getSide()) {
                    // this.pieces[0][x] = new ImageView(cases[i][j].getMPiece().getToken());
                    // this.pieces[0][x].setFitHeight(50);
                    // this.pieces[0][x].setFitWidth(50);
                    // initDragablePiece(this.pieces[0][x]);
                    // this.gdMainGrid.add(this.pieces[0][x++], j, i);
                    // } else {
                    // this.pieces[1][y] = new ImageView(cases[i][j].getMPiece().getToken());
                    // this.pieces[1][y].setFitHeight(50);
                    // this.pieces[1][y].setFitWidth(50);
                    // this.gdMainGrid.add(this.pieces[1][y++], j, i);

                    // }
                }
            }
        }

    }
}
