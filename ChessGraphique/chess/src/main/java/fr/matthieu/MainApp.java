package fr.matthieu;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MainApp extends Application {
    private static Stage stage;

    public static Stage getStage() {return stage;}

    @Override
    public void start(/*@SuppressWarnings("exports")*/ Stage s) throws IOException {
        Stage stage = (new FXMLLoader(MainApp.class.getResource("/fxml/"+ "primary" + ".fxml"))).load();
        stage.setTitle("");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        setRoot(fxml,stage.getTitle());
    }

    static void setRoot(String fxml, String title) throws IOException {
        Scene scene = new Scene(loadFXML(fxml));
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) throws ClassNotFoundException {
        launch(args);
    }

}
