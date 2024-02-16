package Presentation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class MenuGraphique extends Application{
    public void start(Stage primaryStage) throws Exception {
        System.out.println();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("MenuGraphique.fxml")));
        primaryStage.setTitle("Menu");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }


}
