package Presentation;

import Repositories.RecepieRepo;
import models.Recepie;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuTextuel {

    public static void main(String[] args) {
        String[] arg = new String[0];
        RecepieRepo recepieRepo = new RecepieRepo();
        recepieRepo.init(); // Initialiser les données à partir du fichier XML

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\u001B[36m****************************************************");
            System.out.println("\u001B[36m*               Menu Principal                     *");
            System.out.println("\u001B[36m****************************************************");
            System.out.println("\u001B[36m*                                                  *");
            System.out.println("\u001B[36m*  \u001B[32m1. \u001B[32mAfficher les titres des recettes            \u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m2. \u001B[32mAfficher le nombre total d'œufs utilisés    \u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m3. \u001B[32mAfficher les recettes avec de l'huile d'olive\u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m4. \u001B[32mAfficher le nombre d’œufs par recette       \u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m5. \u001B[32mAfficher les recettes avec moins de 500 calories\u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m6. \u001B[32mAfficher la quantité de sucre dans Zuppa Inglese\u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m7. \u001B[32mAfficher les 2 premières étapes de Zuppa Inglese\u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m8. \u001B[32mAfficher les recettes avec plus de 5 étapes  \u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m9. \u001B[32mAfficher les recettes sans beurre          \u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m10.\u001B[32mAfficher les recettes avec ingrédients communs\u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m11.\u001B[32mAfficher la recette la plus calorique       \u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m12.\u001B[32mAfficher l'unité la plus fréquente          \u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m13.\u001B[32mAfficher le nombre d'ingrédients par recette\u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m14.\u001B[32mAfficher la recette avec le plus de matière grasse\u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m15.\u001B[32mAfficher l'ingrédient le plus utilisé       \u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m16.\u001B[32mAfficher les recettes triées par nombre d'ingrédients\u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m17.\u001B[32mAfficher la recette avec le plus de matière grasse (autre méthode)\u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m18.\u001B[32mAfficher l'ingrédient le plus utilisé dans toutes les recettes\u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m19.\u001B[32mAfficher les recettes triées par ingrédients\u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m20.\u001B[32mAfficher la répartition des recettes par étape de réalisation\u001B[36m*");
            System.out.println("\u001B[36m*  \u001B[32m21.\u001B[32mAfficher la recette la plus facile           \u001B[36m*");
            System.out.println("\u001B[36m*                                                  *");
            System.out.println("\u001B[36m*  \u001B[31m0. \u001B[31mQuitter                                     \u001B[36m*");
            System.out.println("\u001B[36m*                                                  *");
            System.out.println("\u001B[36m****************************************************");
            System.out.print("\u001B[36mVeuillez sélectionner une option en entrant le numéro correspondant : ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    List<String> recipeTitles = recepieRepo.getRecipeTitles();
                    System.out.println("\nListe des titres des recettes :");
                    for (String title : recipeTitles) {
                        System.out.println("\u001B[33m★ " + title); // Utilisation de la couleur jaune et d'une étoile
                    }
                    break;
                case 2:
                    int totalEggsUsed = recepieRepo.getTotalEggsUsed();
                    System.out.println("\nNombre total d'œufs utilisés : " + totalEggsUsed);
                    break;
                case 3:
                    List<String> recipesWithOliveOil = recepieRepo.getRecipesUsingOliveOil();
                    System.out.println("\nListe des recettes utilisant l'huile d'olive :");
                    recipesWithOliveOil.forEach(recipe -> System.out.println("\u001B[35m➤ " + recipe));
                    break;
                case 4:
                    List<String> eggsPerRecipe = recepieRepo.getEggsPerRecipe();
                    System.out.println("\nNombre d’œufs par recette :");
                    for (String count : eggsPerRecipe) {
                        System.out.println("\u001B[34m◉ " + count); // Utilisation de la couleur bleue et d'un cercle
                    }
                    break;
                case 5:
                    List<String> recipesUnder500Calories = recepieRepo.getRecipesWithLessThan500Calories();
                    System.out.println("\nRecettes avec moins de 500 calories :");
                    recipesUnder500Calories.forEach(recipe -> System.out.println("\u001B[35m➤ " + recipe));
                    break;
                case 6:
                    double sugarInZuppaInglese = recepieRepo.getSugarUsedInZuppaInglese();
                    System.out.println("\nQuantité de sucre dans Zuppa Inglese : " + sugarInZuppaInglese);
                    break;
                case 7:
                    List<String> firstTwoStepsOfZuppaInglese = recepieRepo.getFirstTwoStepsOfZuppaInglese();
                    System.out.println("\nPremières deux étapes de Zuppa Inglese :");
                    for (String step : firstTwoStepsOfZuppaInglese) {
                        System.out.println("\u001B[33m✓ " + step); // Utilisation de la couleur jaune et d'une coche
                    }
                    break;
                case 8:
                    List<String> recipesWithMoreThan5Steps = recepieRepo.getRecipesWithMoreThan5Steps();
                    System.out.println("\nRecettes avec plus de 5 étapes :");
                    for (String recipe : recipesWithMoreThan5Steps) {
                        System.out.println("\u001B[31m■ " + recipe); // Utilisation de la couleur rouge et d'un carré
                    }
                    break;
                case 9:
                    List<String> recipesWithoutButter = recepieRepo.getRecipesWithoutButter();
                    System.out.println("\nRecettes sans beurre :");
                    recipesWithoutButter.forEach(recipe -> System.out.println("\u001B[32m◆ " + recipe));
                    break;
                case 10:
                    List<String> recipesWithCommonIngredientsWithZuppaInglese = recepieRepo.getRecipesWithCommonIngredientsWithZuppaInglese();
                    System.out.println("\nRecettes avec ingrédients communs avec Zuppa Inglese :");
                    recipesWithCommonIngredientsWithZuppaInglese.forEach(recipe -> System.out.println("\u001B[33m★ " + recipe));
                    break;
                case 11:
                    String mostCaloricRecipe = recepieRepo.getMostCaloricRecipe();
                    System.out.println("\nRecette la plus calorique : " + mostCaloricRecipe);
                    break;
                case 12:
                    String mostCommonUnit = recepieRepo.getMostCommonUnit();
                    System.out.println("\nUnité la plus fréquente : " + mostCommonUnit);
                    break;
                case 13:
                    List<String> ingredientsPerRecipe = recepieRepo.getNumberOfIngredientsPerRecipe();
                    System.out.println("\nNombre d'ingrédients par recette :");
                    for (String count : ingredientsPerRecipe) {
                        System.out.println("\u001B[31m◆ " + count); // Utilisation de la couleur rouge et d'un losange
                    }
                    break;
                case 14, 17:
                    String recipeWithMostFat = recepieRepo.getRecipeWithMostFat();
                    System.out.println("\nRecette avec le plus de matière grasse : " + recipeWithMostFat);
                    break;
                case 15:
                    String mostUsedIngredient = recepieRepo.getMostUsedIngredient();
                    System.out.println("\nIngrédient le plus utilisé : " + mostUsedIngredient);
                    break;
                case 16:
                    List<String> recipesSortedByIngredientCount = recepieRepo.getRecipesSortedByNumberOfIngredients();
                    System.out.println("\nRecettes triées par nombre d'ingrédients :");
                    recipesSortedByIngredientCount.forEach(recipe -> System.out.println("\u001B[32m■ " + recipe));
                    break;
                case 18:
                    String mostUsedIngredientOverall = recepieRepo.getMostUsedIngredient();
                    System.out.println("\nIngrédient le plus utilisé dans toutes les recettes : " + mostUsedIngredientOverall);
                    break;
                case 19:
                    System.out.println("\nListe des Recettes par ingrédients :");
                    recepieRepo.getRecipesByIngredient().forEach(title -> {
                        System.out.println("\u001B[33m★ " + title); // Utilisation de la couleur jaune et d'une étoile
                    });
                    break;

                case 20:
                    Map<String, List<String>> recipesByStep = recepieRepo.getRecipesByPreparationStep();
                    System.out.println("\nRépartition des recettes par étape de réalisation :");
                    recipesByStep.forEach((title, preparationSteps) -> {
                        System.out.println("\u001B[32m■ " + title + " : " + preparationSteps.size() + " étapes"); // Utilisation de la couleur verte et d'un carré
                    });
                    break;

                case 21:
                    String easiestRecipe = recepieRepo.getEasiestRecipe();
                    System.out.println("\nRecette la plus facile : " + easiestRecipe);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("\nChoix invalide, veuillez réessayer !");
            }
            if (choice != 0) {
                System.out.print("\nTapez 1 pour revenir au menu principal ou 0 pour quitter : ");
                int continueChoice = scanner.nextInt();
                if (continueChoice == 0) {
                    running = false;
                }
            }
        }

        System.out.println("\u001B[36m****************************************************");
        System.out.println("\u001B[36m*                 Au revoir !                      *");
        System.out.println("\u001B[36m****************************************************");
    }
}
