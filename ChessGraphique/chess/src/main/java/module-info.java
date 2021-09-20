module fr.matthieu {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens fr.matthieu to javafx.fxml;
    exports fr.matthieu;
    exports fr.matthieu.chess.board;
    exports fr.matthieu.chess.pieces;
    exports fr.matthieu.chess.assets;
}