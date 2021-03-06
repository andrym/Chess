package fr.matthieu;
/*
Put header here


 */

import java.net.URL;

import java.util.ResourceBundle;

import fr.matthieu.chess.board.Board;
import fr.matthieu.chess.board.Case;
import fr.matthieu.chess.pieces.Piece;
import fr.matthieu.utils.Initializer;
import javafx.beans.Observable;
import javafx.beans.binding.DoubleExpression;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    private ImageView[] pieces = new ImageView[32];
    private ImageView draggedPiece;
    private Board mBoard = new Board();
    private Pane panes[][] = new Pane[8][8];

    @FXML
    private GridPane gdMainGrid;

    @FXML private Stage stage;

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

        for (int i = 0; i < 32; i++) {
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
                    && this.mBoard.checkMove(ox, oy, dx, dy, this.mBoard.getCases()[oy][ox].getPiece())) {
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
            Piece piece = this.mBoard.getCases()[oy][ox].getPiece();

            if (db.hasImage()) {
                if (piece.getType() == "Pawn" && piece.getPassed()) {
                    System.out.printf("DropAdded at x: %d y: %d\n", ox, (oy + piece.getMoves()[0][0]));
                    addDropHandling(this.panes[oy + piece.getMoves()[0][0]][ox]);
                }
                if (this.mBoard.isDestEnnemy(dx, dy, piece)) {
                    removePiece(dx, dy);
                }
                removePiece(ox, oy);
                this.mBoard.movePiece(this.mBoard.getCases()[oy][ox], this.mBoard.getCases()[dy][dx], ox, oy, dx, dy);
                this.gdMainGrid.add(this.draggedPiece, dx, dy);
                e.setDropCompleted(true);
                this.draggedPiece = null;
                e.consume();
            }
        });

    }

    public void initDragablePiece(ImageView piece) {
        piece.setOnDragDetected(e -> {
            Dragboard db = piece.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cc = new ClipboardContent();
            SnapshotParameters param = new SnapshotParameters();

            param.setTransform(Transform.translate(-500, -500));
            db.setDragView(piece.snapshot(param, null));
            cc.putImage(piece.getImage());
            db.setContent(cc);
            this.draggedPiece = piece;
            // this.gdMainGrid.getChildren().remove(piece);
            // this.draggedPiece.setTranslateX(-piece.getImage().getWidth()/2);
            // this.draggedPiece.setTranslateY(-piece.getImage().getHeight()/2);
            e.consume();
        });

        piece.setOnDragDone(e -> {
            System.out.println("Done");
        });
    }

    private void onWidth(Observable widthProperty) {
        // System.out.println("resize width callback");
        // double newWidth = ((DoubleExpression) widthProperty).getValue();
        // double newHeight = gdMainGrid.getHeight();
        // // gdMainGrid.setPrefHeight(newHeight);
        // gdMainGrid.setMaxHeight(newHeight);
        // // gdMainGrid.setPrefWidth(newHeight);
        // gdMainGrid.setMaxWidth(newHeight);
        // for (ImageView piece : this.pieces) {
        //     piece.setFitHeight(newHeight / 8);
        //     piece.setFitWidth(newHeight / 8);
        // }
        // for (ColumnConstraints column : gdMainGrid.getColumnConstraints()) {
        //     // column.setPrefWidth(newHeight/8);
        //     column.setMaxWidth(newHeight / 8);
        // }
        // for (RowConstraints row : gdMainGrid.getRowConstraints()) {
        //     // row.setPrefHeight(newHeight/8);
        //     row.setMaxHeight(newHeight / 8);
        // }
    }

    private void onHeight(Observable heightProperty) {
        double newHeight = ((DoubleExpression) heightProperty).getValue() - 100;
        gdMainGrid.setMaxHeight(newHeight);
        gdMainGrid.setMinHeight(newHeight);
        gdMainGrid.setMaxWidth(newHeight);
        for (ImageView piece : this.pieces) {
            piece.setFitHeight(newHeight / 8);
            piece.setFitWidth(newHeight / 8);
        }
        for (ColumnConstraints column : gdMainGrid.getColumnConstraints()) {
            column.setMaxWidth(newHeight / 8);
        }
        for (RowConstraints row : gdMainGrid.getRowConstraints()) {
            row.setMinHeight(newHeight/8);
            row.setMaxHeight(newHeight / 8);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stage.widthProperty().addListener(widthProperty -> onWidth(widthProperty));
        stage.heightProperty().addListener(heightProperty -> onHeight(heightProperty));

        int x = 0;
        Case[][] cases = mBoard.getCases();
        Initializer init = new Initializer();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.panes[i][j] = init.initPane(cases[i][j]);
                addDropHandling(this.panes[i][j]);
                this.gdMainGrid.add(this.panes[i][j], j, i);
                if (!cases[i][j].isEmpty()) {
                    this.pieces[x] = init.initPieces(cases[i][j], i, j);
                    initDragablePiece(this.pieces[x]);
                    this.gdMainGrid.add(this.pieces[x++], j, i);
                    // GridPane.setFillWidth(this.pieces[x - 1], true);
                }
                GridPane.setFillWidth(this.panes[i][j], true);
            }
        }

    }
}
