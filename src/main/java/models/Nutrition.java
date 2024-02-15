package models;

public class Nutrition {
    private int calories;
    private int fat;
    private int carbohydrates;
    private int protein;

    public Nutrition() {
        this.calories = 0;
        this.fat = 0;
        this.carbohydrates = 0;
        this.protein = 0;
    }

    public Nutrition(int calories, int fat, int carbohydrates, int protein) {
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

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
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
        return calories == nutrition.calories && fat == nutrition.fat && carbohydrates == nutrition.carbohydrates && protein == nutrition.protein;
    }

}
