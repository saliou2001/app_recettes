package Presentation;

import Repositories.RecepieRepo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

public class MenuGraphiqueController implements Initializable {
    private RecepieRepo recepieRepo = new RecepieRepo();
    @FXML
    private ImageView btnMenu;

    @FXML
    private HBox titleContainer;
    @FXML
    private ScrollPane content;

    @FXML
    private VBox cardTitre;

    @FXML
    private Label titreLabel;
    @FXML
    private VBox sideMenu;

    @FXML
    void onClickRecette(MouseEvent event) throws IOException {
        // TODO : Afficher la liste des recettes dans un changement de scène
        GridPane gridPane = new GridPane();
        List<String> titreRecettes = this.recepieRepo.getRecipeTitles();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        // TODO : Afficher les recettes en 3 colonnes
        for (int i = 0; i < titreRecettes.size(); i++) {
            cardTitre = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("menu/CardTitreRecette.fxml")));
            HBox hb = (HBox) cardTitre.getChildren().get(1);
            titreLabel = (Label) hb.getChildren().get(0);
            titreLabel.setText(titreRecettes.get(i));
            gridPane.add(cardTitre, i % 2, i / 2);
        }
        content.setContent(gridPane);


    }

    @FXML
    void onClickNumberEggs(MouseEvent event) {
        HBox eggbox = new HBox();
        int nbEggs = recepieRepo.getTotalEggsUsed();
        Label label = new Label("Nombre d'oeufs utilisés : " + nbEggs);
        eggbox.getChildren().add(label);
        content.setContent(eggbox);
    }

    @FXML
    void onclickMenu(MouseEvent event) {
        // TODO : Afficher ou masquer le menu
        if (sideMenu.getPrefWidth() >= 150) {
            sideMenu.setPrefWidth(32);
        } else {
            sideMenu.setPrefWidth(200);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO : Initialiser les données
        recepieRepo.init();
    }
}
