package Repositories;


import models.Recepie;

import java.util.ArrayList;
import java.util.List;

public class RecepieRepo {
    private List<Recepie> recipes;

    // Constructeur
    public RecepieRepo() {
        this.recipes = new ArrayList<>();
    }

    // Méthode pour ajouter une recette à la collection
    public void addRecipe(Recepie recepie) {
        recipes.add(recepie);
    }

    // Méthode pour récupérer toutes les recettes
    public List<Recepie> getAllRecipes() {
        return recipes;
    }

    // Méthode pour récupérer une recette par son identifiant
    public Recepie getRecipeById(String id) {
        for (Recepie recipe : recipes) {
            if (recipe.getId().equals(id)) {
                return recipe;
            }
        }
        return null; // Retourne null si la recette n'est pas trouvée
    }

    // Méthode pour supprimer une recette par son identifiant
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
        return false; // Retourne faux si la recette n'est pas trouvée
    }
}

