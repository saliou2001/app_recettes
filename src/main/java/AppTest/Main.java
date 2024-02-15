package AppTest;

import Repositories.RecepieRepo;

public class Main {

    public static void main(String[] args) {
        RecepieRepo recepieRepo = new RecepieRepo();
        recepieRepo.init();
        //Test zuppa
        //Retourner la liste des titres des ingrédients
        recepieRepo.getRecipesByPreparationStep();


    }
}
