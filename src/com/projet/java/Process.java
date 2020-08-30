package com.projet.java;

import java.util.Scanner;

public class Process {
    private static Scanner clavier;

    ArbreGenealogique arbreGenealogique = null;
    Personne focus = null;

    public static void affichage(Object obj){
        System.out.print(obj);
    }

    public void mainMenu(){
        int repeter = 1;
        do {
            affichage("  Menu  Principale\n\n");
            affichage(" 1 - Creer un arbre \n");
            affichage(" 2 - Choisir un arbre existant \n");
            affichage(" 0 - Quitter \n\n");
            affichage("Choisissez une option... ");
            String option = new Scanner(System.in).next();
            switch (option) {
                case "1":
                    this.arbreGenealogique = new ArbreGenealogique(new Personne("New"));
                    break;
                case "2":
                    affichage("en cours");
                    break;
                case "0":
                    repeter = 0;
                    break;
                default:
                    break;
            }
        }while (repeter!=0);
    }
}
