package csur.app.manager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    private static Scene scene;
    private double  xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) {
        scene = new Scene(loadFXML("LoginView.fxml"));
        stage.setTitle("Gestor de Actividades | Login");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        scene.getRoot().setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        scene.getRoot().setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

        scene.getWindow().setOnCloseRequest(event -> {
            System.exit(0);
        });
    }

    public static void newStage(String fxml){

        Stage stage = new Stage();
        stage.setScene(new Scene(loadFXML(fxml)));
        stage.show();

    }

    private static Parent loadFXML(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        launch();
    }
}