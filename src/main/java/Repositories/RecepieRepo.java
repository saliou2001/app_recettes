package Repositories;


import models.Ingredient;
import models.Recepie;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RecepieRepo {
    private List<Recepie> recipes;


    public RecepieRepo() {
        this.recipes = new ArrayList<>();
    }


    /**
     * Retourner la liste des titres des recettes
     * @return List<String>
     *     La liste des titres des recettes
     */
    public List<String> getRecipeTitles(){
        return this.recipes.stream().map(Recepie::getTitle).toList();
    }

    /**
     * Retouner le nombre total d’œufs utilisés.
     * @return int
     *    Le nombre total d’œufs utilisés
     */
    public int getTotalEggsUsed(){
        return this.recipes.stream().map(Recepie::getIngredients).flatMap(List::stream).filter(ingredient -> ingredient.getName().contains("eggs") || ingredient.getName().startsWith("egg")).mapToInt(ingredient -> (int) ingredient.getAmount()).sum();
    }

    /**
     * Retourner les recettes utilisant l’huile d’olive
     * @return List<String>
     *     La liste des titres des recettes utilisant l’huile d’olive
     */
    public List<String> getRecipesUsingOliveOil(){
        return this.recipes.stream().filter(recepie -> recepie.getIngredients().stream().anyMatch(ingredient -> ingredient.getName().equals("olive oil"))).map(Recepie::getTitle).toList();
    }

    /**
     * Retourner le nombre d’œufs par recette
     * @return
     *
     */
    public List<String> getEggsPerRecipe(){
        return this.recipes.stream().map(recepie -> recepie.getTitle() + " : " + recepie.getIngredients().stream().filter(ingredient -> ingredient.getName().contains("eggs") || ingredient.getName().startsWith("egg")).map(ingredient -> (int) ingredient.getAmount()).reduce(0, Integer::sum)).toList();
    }

    /**
     * Retourner les recettes fournissant moins de 500 calories
     *
     */
    public List<Recepie> getRecipesWithLessThan500Calories(){
        return this.recipes.stream().filter(recepie -> recepie.getNutrition().getCalories() < 500).toList();
    }

    /**
     * Retourne la quantité de sucre utilisée par la recette Zuppa Inglese
     */
    public double getSugarUsedInZuppaInglese(){
        return this.recipes.stream().filter(recepie -> recepie.getTitle().equals("Zuppa Inglese")).flatMap(recepie -> recepie.getIngredients().stream()).filter(ingredient -> ingredient.getName().equals("sugar")).mapToDouble(ingredient -> ingredient.getAmount()).sum();
    }

    /**
     * Afficher les 2 premières étapes de la recette Zuppa Inglese
     */
    public List<String> getFirstTwoStepsOfZuppaInglese(){
        return this.recipes.stream().filter(recepie -> recepie.getTitle().equals("Zuppa Inglese")).flatMap(recepie -> recepie.getPreparationSteps().stream().limit(2)).toList();
    }

    /**
     * Retourner les recettes qui nécessitent plus de 5 étapes
     */
    public List<String> getRecipesWithMoreThan5Steps(){
        return this.recipes.stream().filter(recepie -> recepie.getPreparationSteps().size() > 5).map(Recepie::getTitle).toList();
    }

    /**
     * Retourner les recettes qui ne contiennent pas de beure
     */
    public List<Recepie> getRecipesWithoutButter(){
        return this.recipes.stream().filter(recepie -> recepie.getIngredients().stream().noneMatch(ingredient -> ingredient.getName().equals("butter"))).toList();
    }

    /**
     * Retourner les recettes ayant des ingrédients en communs avec la recette Zuppa Inglese
     *
     */
    public List<Recepie> getRecipesWithCommonIngredientsWithZuppaInglese(){
        return this.recipes.stream().filter(recepie -> hasCommonIngredients(recepie, this.recipes.stream().filter(recipe -> recipe.getTitle().equals("Zuppa Inglese")).flatMap(recipe -> recipe.getIngredients().stream()).toList())).toList();
    }

    /**
     * Retourner les recettes ayant des ingrédients en communs avec la recette Zuppa Inglese
     *
     */
    private boolean hasCommonIngredients(Recepie recipe, List<Ingredient> commonIngredients) {
        List<Ingredient> ingredients = recipe.getIngredients();

        // Check if any ingredient in the recipe is present in the commonIngredients list
        return ingredients.stream()
                .anyMatch(ingredient -> commonIngredients.stream()
                        .anyMatch(commonIngredient -> commonIngredient.getName().equalsIgnoreCase(ingredient.getName())));
    }


    /**
     *  Afficher la recette la plus calorique
     */
    public Recepie getMostCaloricRecipe(){
        return this.recipes.stream().max((recipe1, recipe2) -> recipe1.getNutrition().getCalories() - recipe2.getNutrition().getCalories()).get();
    }

    /**
     * Retourner l’unité la plus fréquente
     */
    public String getMostCommonUnit() {
        Map<String, Long> unitFrequency = recipes.stream()
                .flatMap(recipe -> recipe.getIngredients().stream())
                .filter(ingredient -> ingredient.getUnit() != null && !ingredient.getUnit().isEmpty())
                .map(ingredient -> ingredient.getUnit().toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return unitFrequency.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("No unit found");
    }

    /**
     * Calcule le nombre d’ingrédients par recette
     */
    public List<String> getNumberOfIngredientsPerRecipe() {
        return recipes.stream()
                .map(recipe -> recipe.getTitle() + " : " + recipe.getIngredients().size())
                .toList();
    }

    /**
     * Retourne la recette comportant le plus de fat
     */
    public Recepie getRecipeWithMostFat() {
        return recipes.stream()
                .max(Comparator.comparing(recipe -> recipe.getNutrition().getFat()))
                .orElse(null);
    }

    /**
     *  Calcule l’ingrédient le plus utilisé
     */
    public String getMostUsedIngredient() {
        Map<String, Long> ingredientFrequency = recipes.stream()
                .flatMap(recipe -> recipe.getIngredients().stream())
                .map(Ingredient::getName)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return ingredientFrequency.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("No ingredient found");
    }

    /**
     * Afficher les recettes triées par nombre d’ingrédients
     */
    public List<Recepie> getRecipesSortedByNumberOfIngredients() {
        return recipes.stream()
                .sorted(Comparator.comparingInt(recipe -> recipe.getIngredients().size()))
                .toList();
    }

    /**
     * Afficher pour chaque ingrédient, les recettes qui l’utilisent
     */
    public void getRecipesByIngredient() {
        Map<String, List<Recepie>> recipesByIngredient = recipes.stream()
                .flatMap(recipe -> recipe.getIngredients().stream())
                .collect(Collectors.groupingBy(Ingredient::getName, Collectors.mapping(ingredient -> recipes.stream()
                        .filter(recipe -> recipe.getIngredients().contains(ingredient))
                        .findFirst()
                        .orElse(null), Collectors.toList())));

        recipesByIngredient.forEach((ingredient, ingredientRecipes) -> {
            System.out.println(ingredient + " : " + ingredientRecipes.stream()
                    .filter(recipe -> recipe != null)
                    .map(Recepie::getTitle)
                    .collect(Collectors.joining(", ")));
        });
    }

    /**
     * Calculer la répartition des recettes par étape de réalisation
     */
    public void getRecipesByPreparationStep() {
        Map<String, List<Recepie>> recipesByPreparationStep = recipes.stream()
                .flatMap(recipe -> recipe.getPreparationSteps().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.mapping(recipe -> recipes.stream()
                        .filter(r -> r.getPreparationSteps().contains(recipe))
                        .findFirst()
                        .orElse(null), Collectors.toList())));

        recipesByPreparationStep.forEach((step, stepRecipes) -> {
            System.out.println(step + " : " + stepRecipes.stream()
                    .filter(recipe -> recipe != null)
                    .map(Recepie::getTitle)
                    .collect(Collectors.joining(", ")));
        });
    }

    /**
     * Calcule la recette la plus facile (avec le moins d’étape)
     */
    public Recepie getEasiestRecipe() {
        return recipes.stream()
                .min(Comparator.comparingInt(recipe -> recipe.getPreparationSteps().size()))
                .orElse(null);
    }



    public void init() {
        String filePath = "data/recipes.xml";
        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList recipeList = doc.getElementsByTagName("rcp:recipe");

            for (int temp = 0; temp < recipeList.getLength(); temp++) {
                Node recipeNode = recipeList.item(temp);

                if (recipeNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element recipeElement = (Element) recipeNode;
                    Recepie recipe = parseRecipe(recipeElement);
                    recipes.add(recipe);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Recepie parseRecipe(Element recipeElement) {
        String id = recipeElement.getAttribute("id");
        String title = recipeElement.getElementsByTagName("rcp:title").item(0).getTextContent();
        String date = recipeElement.getElementsByTagName("rcp:date").item(0).getTextContent();
        List<String> preparationSteps = new ArrayList<>();
        List<String> comments = new ArrayList<>();
        List<models.Ingredient> ingredients = new ArrayList<>();
        models.Nutrition nutrition = new models.Nutrition();
        String relatedRecipeId = "";
        String relatedRecipeDesc = "";

        NodeList preparationStepsList = recipeElement.getElementsByTagName("rcp:preparation");

        for (int i = 0; i < preparationStepsList.getLength(); i++) {
            preparationSteps.add(preparationStepsList.item(i).getTextContent());
        }

        NodeList commentsList = recipeElement.getElementsByTagName("rcp:comment");
        for (int i = 0; i < commentsList.getLength(); i++) {
            comments.add(commentsList.item(i).getTextContent());
        }

        NodeList ingredientList = recipeElement.getElementsByTagName("rcp:ingredient");

        for (int i = 0; i < ingredientList.getLength(); i++) {
            Node ingredientNode = ingredientList.item(i);
            if (ingredientNode.getNodeType() == Node.ELEMENT_NODE) {
                Element ingredientElement = (Element) ingredientNode;
                    String name = ingredientElement.getAttribute("name");
                    //System.out.println("amout"+(ingredientElement.getAttribute("amount").isEmpty() || ingredientElement.getAttribute("amount").equals("*")  ? "0": ingredientElement.getAttribute("amount")));
                    double amount = Double.parseDouble(ingredientElement.getAttribute("amount").isEmpty() || ingredientElement.getAttribute("amount").equals("*")  ? "0": ingredientElement.getAttribute("amount"));
                    String unit = ingredientElement.getAttribute("unit");
                    models.Ingredient ingredient = new models.Ingredient(name, amount, unit);
                    ingredients.add(ingredient);
            }
        }

        Element nutritionElement = (Element) recipeElement.getElementsByTagName("rcp:nutrition").item(0);
        nutrition.setCalories(Integer.parseInt(nutritionElement.getAttribute("calories")));
        nutrition.setProtein(Integer.parseInt(nutritionElement.getAttribute("protein").substring(0, nutritionElement.getAttribute("protein").length() - 1)));
        nutrition.setFat(Integer.parseInt(nutritionElement.getAttribute("fat").substring(0, nutritionElement.getAttribute("fat").length() - 1)));
        nutrition.setCarbohydrates(Integer.parseInt(nutritionElement.getAttribute("carbohydrates").substring(0, nutritionElement.getAttribute("carbohydrates").length() - 1)));


        if (recipeElement.getElementsByTagName("rcp:related").getLength() > 0) {
            relatedRecipeId = recipeElement.getElementsByTagName("rcp:related").item(0).getAttributes().getNamedItem("ref").getNodeValue();
            relatedRecipeDesc = recipeElement.getElementsByTagName("rcp:related").item(0).getTextContent();
        }
        return new Recepie(id, title, date, ingredients, preparationSteps, comments, nutrition, relatedRecipeId, relatedRecipeDesc);
    }

    public void addRecipe(Recepie recepie) {
        recipes.add(recepie);
    }


    public List<Recepie> getAllRecipes() {
        return recipes;
    }


    public Recepie getRecipeById(String id) {
        for (Recepie recipe : recipes) {
            if (recipe.getId().equals(id)) {
                return recipe;
            }
        }
        return null;
    }


    public boolean deleteRecipeById(String id) {
        Recepie recipeToRemove = null;
        for (Recepie recipe : recipes) {
            if (recipe.getId().equals(id)) {
                recipeToRemove = recipe;
                break;
            }
        }
        if (recipeToRemove != null) {
            recipes.remove(recipeToRemove);
            return true; // Retourne vrai si la suppression est réussie
        }
        return false;
    }
}

