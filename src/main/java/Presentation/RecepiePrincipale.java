package Presentation;

import java.util.Scanner;

public class RecepiePrincipale {

    public static void main(String[] args) {
        String reset = "*";
        String cyanBold = "\u001B[1;36m";
        String yellowBold = "\u001B[1;33m";
        String purpleBold = "\u001B[1;35m";
        String greenBold = "\u001B[1;32m";
        String star = "🌟";
        Scanner scanner = new Scanner(System.in);

        // Texte "Bienvenue dans l'application"
        String bienvenueTexte = "Bienvenue dans l'application";
        // Calcul de la longueur de la ligne pour centrer le texte
        int longueurLigne = 60;
        int espacesAvant = (longueurLigne - bienvenueTexte.length()) / 2;
        int espacesApres = longueurLigne - bienvenueTexte.length() - espacesAvant;

        // Affichage du texte centré avec des étoiles décoratives et des couleurs
        System.out.println(cyanBold + "*".repeat(longueurLigne) + reset);
        System.out.println(cyanBold + "*".repeat(espacesAvant) + yellowBold + bienvenueTexte + reset +
                cyanBold + "*".repeat(espacesApres) + reset);
        System.out.println(cyanBold + "*".repeat(longueurLigne) + reset);

        // Affichage du menu avec des couleurs pour chaque partie du texte
        System.out.println(yellowBold + greenBold + star + " " + cyanBold + "1. " + reset + yellowBold + "Menu Textuel" + reset +
                "\t\t" + yellowBold + greenBold + star + " " + cyanBold + "2. " + reset + yellowBold + "Menu Graphique" + reset +
                "\t\t" + purpleBold + star + " " + cyanBold + "0. " + reset + purpleBold + "Quitter" + reset);
        System.out.print(yellowBold + "Votre choix : " + reset);

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                MenuTextuel.main(null); // Appeler la classe MenuTextuel
                break;
            case 2:
                MenuGraphique.launch(MenuGraphique.class, args); // Appeler la classe MenuGraphique
                break;
                case 0:
                    System.exit(0);
                System.out.println("Au revoir !");
            default:
                System.out.println("Choix invalide !");
        }

        scanner.close();
    }
}
