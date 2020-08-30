package com.projet.java;

import java.util.Scanner;

public class Process {
    private static Scanner clavier;

    public static void affichage(Object obj){
        System.out.print(obj);
    }

    public static void mainMenu(){
        affichage("  Menu  Principale\n\n");
        affichage(" 1 - Creer un arbre \n");
        affichage(" 2 - Choisir un arbre existant \n");
        affichage(" 0 - Quitter \n\n");
        affichage("Choisissez une option... ");
    }
}
