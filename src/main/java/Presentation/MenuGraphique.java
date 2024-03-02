package Presentation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.util.Objects;

public class MenuGraphique extends Application{
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("MenuGraphique.fxml")));
        primaryStage.setTitle("Recette");
        primaryStage.getIcons().add(new javafx.scene.image.Image(new FileInputStream("breakfast-2151201_1280.jpg")));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinWidth(900);
        primaryStage.setMinHeight(600);
        primaryStage.setMaxWidth(900);
        primaryStage.setMaxHeight(600);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }


}
