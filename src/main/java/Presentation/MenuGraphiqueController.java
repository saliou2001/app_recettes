package Presentation;

import Repositories.RecepieRepo;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.FileInputStream;
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
    private ImageView bg;
    @FXML
    private Button btn;

    @FXML
    private Pane pan;
    @FXML
    private Button closeBtn;


    @FXML
    void onClickHome(MouseEvent event) {
        // TODO : Charger la page d'accueil
        Pane pan = new Pane();
        pan.setPrefSize(558,491);
        bg.setFitWidth(621);
        bg.setFitHeight(500);
        pan.getChildren().add(bg);
        Button btn = new Button("Consulter les recettes");
        btn.setPrefWidth(211);
        btn.setPrefHeight(106);
        btn.setLayoutX(218);
        btn.setLayoutY(246);
        //class
        btn.getStyleClass().add("btn-primary");
        //action
        btn.setOnAction(e ->{
            try {
                onClickRecette(event);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        pan.getChildren().add(btn);
        content.setContent(pan);

    }

    @FXML
    void onClose(ActionEvent event) {
        // Demander la confirmation de fermeture
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Fermeture de l'application");
        alert.setHeaderText("Voulez-vous vraiment quitter l'application ?");
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            System.exit(0);
        }


    }

    @FXML
    void onClickRecette(MouseEvent event) throws IOException {
        // TODO : Afficher la liste des recettes dans un changement de scène
        GridPane gridPane = new GridPane();
        List<String> titreRecettes = this.recepieRepo.getRecipeTitles();
        List<String> images = List.of("src/main/resources/images/beef.jpg","src/main/resources/images/rico-pi.jpg","src/main/resources/images/pescatoro.jpg","src/main/resources/images/zi.jpg","src/main/resources/images/cailleSarco.jpg");
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        // TODO : Afficher les recettes en 3 colonnes
        for (int i = 0; i < titreRecettes.size(); i++) {
            cardTitre = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("menu/CardTitreRecette.fxml")));
            HBox hb = (HBox) cardTitre.getChildren().get(1);
            titreLabel = (Label) hb.getChildren().get(0);
            titreLabel.setText(titreRecettes.get(i));
            HBox himg = (HBox) cardTitre.getChildren().get(0);
            ImageView img = (ImageView) himg.getChildren().get(0);
            Image image = new Image(new FileInputStream(images.get(i)));
            img.setImage(image);
            gridPane.add(cardTitre, i % 2, i / 2);
        }
        content.setContent(gridPane);


    }

    @FXML
    void onClickNumberEggs(MouseEvent event) {
        HBox eggbox = new HBox();
        eggbox.setPrefSize(558,491);
        int nbEggs = recepieRepo.getTotalEggsUsed();
        Label label = new Label("Nombre d'oeufs utilisés : " + nbEggs);
        eggbox.getChildren().add(label);
        content.setContent(eggbox);
    }


    @FXML
    void onClickRecetteOil(MouseEvent event) {
        HBox oilBox = new HBox();
        ListView<String> listView = new ListView<>();
        List<String> oilMap = recepieRepo.getRecipesUsingOliveOil();
        oilMap.forEach(listView.getItems()::add);
        oilBox.getChildren().add(listView);
        content.setContent(oilBox);
    }

    @FXML
    void onClickEggsPerRecipe(MouseEvent event) {
        HBox eggsPerRecipeBox = new HBox();
        List<String> eggsPerRecipe = recepieRepo.getEggsPerRecipe();
        ListView<String> listView = new ListView<>();
        //dimension
        listView.setPrefSize(500, 250);
        eggsPerRecipe.forEach(listView.getItems()::add);
        eggsPerRecipeBox.getChildren().add(listView);
        content.setContent(eggsPerRecipeBox);
    }

    @FXML
    void onClickInf(MouseEvent event) {
        System.out.println("Inf 500");
        HBox inf500Box = new HBox();
        List<String> inf500 = recepieRepo.getRecipesWithLessThan500Calories();
        ListView<String> listView = new ListView<>();
        listView.setPrefSize(500, 250);
        inf500.forEach(listView.getItems()::add);
        inf500Box.getChildren().add(listView);
        System.out.println(inf500);
        content.setContent(inf500Box);
    }

    @FXML
    void onClickSucreZI(MouseEvent event) {
        HBox sucreZIBox = new HBox();
        double sucreZI = recepieRepo.getSugarUsedInZuppaInglese();
        Label label = new Label("Sucre utilisé dans la Zuppa Inglese : " + sucreZI);
        sucreZIBox.getChildren().add(label);
        content.setContent(sucreZIBox);

    }

    @FXML
    void onClickEasyRecipe(MouseEvent event) {
        HBox easyRecipeBox = new HBox();
        String easyRecipe = recepieRepo.getEasiestRecipe();
        Label label = new Label("Recette la plus facile : " + easyRecipe);
        easyRecipeBox.getChildren().add(label);
        content.setContent(easyRecipeBox);
    }



    @FXML
    void onClickFatRecepie(MouseEvent event) {
        HBox fatRecepieBox = new HBox();
        String fatRecepie = recepieRepo.getRecipeWithMostFat();
        Label label = new Label("Recette la plus grasse : " + fatRecepie);
        fatRecepieBox.getChildren().add(label);
        content.setContent(fatRecepieBox);

    }

    @FXML
    void onClickFirstTwoStepZI(MouseEvent event) {
        HBox firstTwoStepZIBox = new HBox();
        List<String> firstTwoStepZI = recepieRepo.getFirstTwoStepsOfZuppaInglese();
        ListView<String> listView = new ListView<>();
        listView.setPrefSize(500, 500);
        firstTwoStepZI.forEach(listView.getItems()::add);
        firstTwoStepZIBox.getChildren().add(listView);
        content.setContent(firstTwoStepZIBox);

    }


    @FXML
    void onClickIngredientList(MouseEvent event) {
        HBox ingredientListBox = new HBox();
        List<String> ingredientList = recepieRepo.getRecipesByIngredient();
        ListView<String> listView = new ListView<>();
        System.out.println(ingredientList.get(0));
        listView.setPrefSize(500, 500);
        ingredientList.forEach(t -> listView.getItems().add(t));
        ingredientListBox.getChildren().add(listView);
        content.setContent(ingredientListBox);
    }

    @FXML
    void onClickIngredientPerRecepie(MouseEvent event) {
        HBox ingredientPerRecepieBox = new HBox();
        List<String> ingredientPerRecepie = recepieRepo.getNumberOfIngredientsPerRecipe();
        ListView<String> listView = new ListView<>();
        listView.setPrefSize(500, 500);
        ingredientPerRecepie.forEach(listView.getItems()::add);
        ingredientPerRecepieBox.getChildren().add(listView);
        content.setContent(ingredientPerRecepieBox);

    }

    @FXML
    void onClickIngredientUsed(MouseEvent event) {
        HBox ingredientUsedBox = new HBox();
        String ingredientUsed = recepieRepo.getMostUsedIngredient();
        Label label = new Label("Ingrédient le plus utilisé : " + ingredientUsed);
        ingredientUsedBox.getChildren().add(label);
        content.setContent(ingredientUsedBox);

    }

    @FXML
    void onClickMostUnit(MouseEvent event) {
        HBox mostUnitBox = new HBox();
        String mostUnit = recepieRepo.getMostCommonUnit();
        Label label = new Label("Unité la plus utilisée : " + mostUnit);
        mostUnitBox.getChildren().add(label);
        content.setContent(mostUnitBox);

    }



    @FXML
    void onClickRecepieByIng(MouseEvent event) {
        HBox recepieByIngBox = new HBox();
        List<String> recepieByIng = recepieRepo.getRecipesSortedByNumberOfIngredients();
        ListView<String> listView = new ListView<>();
        listView.setPrefSize(500, 500);
        recepieByIng.forEach(listView.getItems()::add);
        recepieByIngBox.getChildren().add(listView);
        content.setContent(recepieByIngBox);

    }



    @FXML
    void onClickRecette5Step(MouseEvent event) {
        HBox recette5StepBox = new HBox();
        List<String> recette5Step = recepieRepo.getRecipesWithMoreThan5Steps();
        ListView<String> listView = new ListView<>();
        listView.setPrefSize(500, 500);
        recette5Step.forEach(listView.getItems()::add);
        recette5StepBox.getChildren().add(listView);
        content.setContent(recette5StepBox);

    }

    @FXML
    void onClickWithoutButter(MouseEvent event) {
        HBox withoutButterBox = new HBox();
        List<String> withoutButter = recepieRepo.getRecipesWithoutButter();
        ListView<String> listView = new ListView<>();
        listView.setPrefSize(500, 500);
        withoutButter.forEach(listView.getItems()::add);
        withoutButterBox.getChildren().add(listView);
        content.setContent(withoutButterBox);
    }
    @FXML
    void onClickCalorique(MouseEvent event) {
        HBox caloriqueBox = new HBox();
        String calorique = recepieRepo.getMostCaloricRecipe();
        Label label = new Label("Recette la plus calorique : " + calorique);
        caloriqueBox.getChildren().add(label);
        content.setContent(caloriqueBox);
    }

    @FXML
    void onClickRepartitionStep(MouseEvent event) {
        HBox repartitionStepBox = new HBox();
        Map<String, List<String>> repartitionStep = recepieRepo.getRecipesByPreparationStep();
        ListView<String> listViewRecette = new ListView<>();
        listViewRecette.setPrefSize(500, 500);
        /**
         * recipesByStep.forEach((title, preparationSteps) -> {
         *                         System.out.println("\u001B[32m■ " + title + " : " + preparationSteps.size() + " étapes"); // Utilisation de la couleur verte et d'un carré
         *                     });
         */

        repartitionStep.forEach((title, preparationSteps) -> {
            listViewRecette.getItems().add(title + " : " + preparationSteps.size() + " étapes");
        });

        repartitionStepBox.getChildren().add(listViewRecette);
        content.setContent(repartitionStepBox);

    }
    @FXML
    void onclickMenu(MouseEvent event) {
        // TODO : Afficher ou masquer le menu
        if (sideMenu.getPrefWidth() >= 150) {
            sideMenu.setPrefWidth(32);
        } else {
            sideMenu.setPrefWidth(269);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO : Initialiser les données
        recepieRepo.init();
    }
}
