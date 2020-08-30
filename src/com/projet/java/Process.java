package com.projet.java;

import java.util.Scanner;

public class Process {
    private static Scanner clavier;

    ArbreGenealogique arbreGenealogique = new ArbreGenealogique();
    Personne root = null;

    public static void affichage(Object obj){
        System.out.print(obj);
    }

    public static void mainMenu(){
        int repeter = 1;
        while(repeter!=0) {
            affichage("  Menu  Principale\n\n");
            affichage(" 1 - Creer un arbre \n");
            affichage(" 2 - Choisir un arbre existant \n");
            affichage(" 0 - Quitter \n\n");
            affichage("Choisissez une option... ");
            String option = new Scanner(System.in).next();
            switch (option){
                case"1":
                    break;
                case"2":
                    break;
                case"0":
                    repeter =0;
                    break;
                default:
                    break;
        }
    }
}
