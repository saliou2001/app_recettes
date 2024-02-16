package Presentation;

import Repositories.RecepieRepo;
import models.Recepie;

import java.util.Scanner;
import java.util.List;

public class MenuTextuel {

    public static void main(String[] args) {
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
                    for (String recipe : recipesWithOliveOil) {
                        System.out.println("\u001B[35m➤ " + recipe); // Utilisation de la couleur mauve et d'une flèche
                    }
                    break;
                case 4:
                    List<String> eggsPerRecipe = recepieRepo.getEggsPerRecipe();
                    System.out.println("\nNombre d'œufs par recette :");
                    for (String eggCount : eggsPerRecipe) {
                        System.out.println("\u001B[34m○ " + eggCount); // Utilisation de la couleur bleue et d'un cercle
                    }
                    break;
                case 6:
                    double sugarUsedInZuppaInglese = recepieRepo.getSugarUsedInZuppaInglese();
                    System.out.println("\nQuantité de sucre utilisée dans Zuppa Inglese : " + sugarUsedInZuppaInglese);
                    break;
                case 7:
                    List<String> firstTwoStepsOfZuppaInglese = recepieRepo.getFirstTwoStepsOfZuppaInglese();
                    System.out.println("\n2 premières étapes de Zuppa Inglese :");
                    for (String step : firstTwoStepsOfZuppaInglese) {
                        System.out.println("\u001B[32m● " + step); // Utilisation de la couleur verte et d'un point
                    }
                    break;
                case 8:
                    List<String> recipesWithMoreThan5Steps = recepieRepo.getRecipesWithMoreThan5Steps();
                    System.out.println("\nRecettes avec plus de 5 étapes :");
                    for (String recipe : recipesWithMoreThan5Steps) {
                        System.out.println("\u001B[31m◆ " + recipe); // Utilisation de la couleur rouge et d'un losange
                    }
                    break;
                case 10:
                    List<Recepie> recipesWithCommonIngredients = recepieRepo.getRecipesWithCommonIngredientsWithZuppaInglese();
                    System.out.println("\nRecettes avec ingrédients communs avec Zuppa Inglese :");
                    for (Recepie recipe : recipesWithCommonIngredients) {
                        System.out.println("\u001B[32m■ " + recipe); // Utilisation de la couleur verte et d'un carré
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("\nOption invalide !");
            }

            // Demander à l'utilisateur s'il veut retourner au menu principal ou quitter
            if (running) {
                System.out.print("\nTapez 1 pour retourner au menu principal ou 0 pour quitter : ");
                int continueChoice = scanner.nextInt();
                if (continueChoice == 0) {
                    running = false;
                }
            }
        }
        scanner.close();
    }
}
