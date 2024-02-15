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


    public Recepie(String id, String title, String date, List<Ingredient> ingredients, List<String> preparationSteps, List<String> comments, Nutrition nutrition, String relatedRecepieId, String relatedRecepieDesc) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.ingredients = ingredients;
        this.preparationSteps = preparationSteps;
        this.comments = comments;
        this.nutrition = nutrition;
        this.relatedRecepieId = relatedRecepieId;
        this.relatedRecepieDesc = relatedRecepieDesc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getPreparationSteps() {
        return preparationSteps;
    }

    public void setPreparationSteps(List<String> preparationSteps) {
        this.preparationSteps = preparationSteps;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }

    public String getRelatedRecepieId() {
        return relatedRecepieId;
    }

    public void setRelatedRecepieId(String relatedRecepieId) {
        this.relatedRecepieId = relatedRecepieId;
    }

    public String getRelatedRecepieDesc() {
        return relatedRecepieDesc;
    }

    public void setRelatedRecepieDesc(String relatedRecepieDesc) {
        this.relatedRecepieDesc = relatedRecepieDesc;
    }

    @Override
    public Boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Recepie recepie = (Recepie) obj;
        return id.equals(recepie.id) && title.equals(recepie.title) && date.equals(recepie.date) && ingredients.equals(recepie.ingredients) && preparationSteps.equals(recepie.preparationSteps) && comments.equals(recepie.comments) && nutrition.equals(recepie.nutrition) && relatedRecepieId.equals(recepie.relatedRecepieId) && relatedRecepieDesc.equals(recepie.relatedRecepieDesc);
    }

    @Override
    public String toString() {
        return "Recepie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", ingredients=" + ingredients +
                ", preparationSteps=" + preparationSteps +
                ", comments=" + comments +
                ", nutrition=" + nutrition +
                ", relatedRecepieId='" + relatedRecepieId + '\'' +
                ", relatedRecepieDesc='" + relatedRecepieDesc + '\'' +
                '}';
    }
}
