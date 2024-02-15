package models;

public class Nutrition {
    private int calories;
    private String fat;
    private String carbohydrates;
    private String protein;

    public Nutrition(int calories, String fat, String carbohydrates, String protein) {
        this.calories = calories;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(String carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    @Override
    public String toString() {
        return "Nutrition{" +
                "calories=" + calories +
                ", fat='" + fat + '\'' +
                ", carbohydrates='" + carbohydrates + '\'' +
                ", protein='" + protein + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Nutrition nutrition = (Nutrition) obj;
        return calories == nutrition.calories && fat.equals(nutrition.fat) && carbohydrates.equals(nutrition.carbohydrates) && protein.equals(nutrition.protein);
    }
}
