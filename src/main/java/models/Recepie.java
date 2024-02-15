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

}
