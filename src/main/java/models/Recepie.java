package models;

import java.util.List;

public class Recepie {
    private String id;
    private String title;
    private String date;
    private List<Ingredient> ingredients;
    private List<String> preparationSteps;
    private List<String> comments;
    private Nutrition nutrition;
    private String relatedRecepieId;
    private String relatedRecepieDesc;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<String> getPreparationSteps() {
        return preparationSteps;
    }

    public List<String> getComments() {
        return comments;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public String getRelatedRecepieId() {
        return relatedRecepieId;
    }

    public String getRelatedRecepieDesc() {
        return relatedRecepieDesc;
    }
}
