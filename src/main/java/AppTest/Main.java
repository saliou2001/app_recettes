package AppTest;

import Presentation.MenuGraphique;
import Presentation.MenuTextuel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez sélectionner le mode d'affichage :");
        System.out.println("1. Menu Textuel");
        System.out.println("2. Menu Graphique");
        System.out.print("Votre choix : ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                MenuTextuel.main(null); // Appeler la classe MenuTextuel
                break;
            case 2:
                MenuGraphique.launch(MenuGraphique.class, args); // Appeler la classe MenuGraphique
                break;
            default:
                System.out.println("Choix invalide !");
        }

        scanner.close();
    }
}
